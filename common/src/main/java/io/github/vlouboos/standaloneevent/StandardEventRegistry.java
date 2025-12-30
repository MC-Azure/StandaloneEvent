// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 License.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent;

import io.github.vlouboos.standaloneevent.api.*;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StandardEventRegistry implements StandaloneEvent {
    private static final ConcurrentHashMap<Class<? extends Event>, LinkedList<MethodInstance>> registry = new ConcurrentHashMap<>();

    @Override
    public void register(Object @NotNull ... instances) {
        synchronized (registry) {
            HashSet<Class<? extends Event>> edited = new HashSet<>();
            for (Object instance : instances) {
                Class<?> cls = instance instanceof Class ? (Class<?>) instance : instance.getClass();
                for (Method method : cls.getDeclaredMethods()) {
                    // Validate
                    if (method.isAnnotationPresent(EventHandler.class)
                            && method.getParameterCount() == 1
                            && Event.class.isAssignableFrom(method.getParameterTypes()[0])
                            && (((method.getModifiers() & Modifier.STATIC) == 0 && !(instance instanceof Class)) || (Modifier.isStatic(method.getModifiers()) && instance instanceof Class))
                    ) {
                        @SuppressWarnings("unchecked")
                        Class<? extends Event> eventClass = (Class<? extends Event>) method.getParameterTypes()[0];
                        EventHandler handler = method.getAnnotation(EventHandler.class);
                        registry.putIfAbsent(eventClass, new LinkedList<>());
                        edited.add(eventClass);
                        synchronized (registry.get(eventClass)) {
                            registry.get(eventClass).add(new MethodInstance(instance, method, handler.value()));
                        }
                    }
                }
            }
            edited.forEach(e -> registry.get(e).sort(Comparator.comparingLong(m -> m.weight)));
        }
    }

    @Override
    public void unregister(Object @NotNull ... instances) {
        List<Object> list = Arrays.asList(instances);
        synchronized (registry) {
            for (Class<? extends Event> eventClass : registry.keySet()) {
                synchronized (registry.get(eventClass)) {
                    registry.get(eventClass).removeIf(m -> list.contains(m.parent));
                }
            }
        }
    }

    @Override
    public void call(@NotNull Event event) {
        synchronized (registry) {
            if (registry.containsKey(event.getClass())) {
                synchronized (registry.get(event.getClass())) {
                    registry.get(event.getClass()).forEach(methodInstance -> {
                        try {
                            methodInstance.method.invoke(methodInstance.parent, event);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }
    }

    @Override
    public boolean isRegistered(@NotNull Object instance) {
        throw new UnsupportedOperationException("Standard Event Registry does not support duplication queries.");
    }

    @Override
    public void makeDuplicatable() {
        throw new UnsupportedOperationException("Already duplicated.");
    }

    @Override
    public @NotNull String getRegistryName() {
        return "Standard Event Registry";
    }

    @AllArgsConstructor
    private static class MethodInstance {
        private Object parent;
        private Method method;
        private long weight;
    }
}
