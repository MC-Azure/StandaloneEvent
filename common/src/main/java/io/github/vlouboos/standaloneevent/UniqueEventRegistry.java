// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 License.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent;

import io.github.vlouboos.standaloneevent.api.StandaloneEvent;
import io.github.vlouboos.standaloneevent.api.StandaloneEventAPI;
import io.github.vlouboos.standaloneevent.exception.DuplicatedRegistryException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UniqueEventRegistry extends StandardEventRegistry {
    private final Set<Object> instances = ConcurrentHashMap.newKeySet();

    @Override
    public void register(Object @NotNull ... instances) {
        synchronized (this) {
            for (Object instance : instances) {
                if (this.instances.contains(instance)) {
                    throw new DuplicatedRegistryException(instance);
                }
            }
            this.instances.addAll(Arrays.asList(instances));
            super.register(instances);
        }
    }

    @Override
    public void unregister(Object @NotNull ... instances) {
        synchronized (this) {
            for (Object instance : instances) {
                this.instances.remove(instance);
            }
            super.unregister(instances);
        }
    }

    @Override
    public boolean isRegistered(@NotNull Object instance) {
        return this.instances.contains(instance);
    }

    @SneakyThrows
    @Override
    public void makeDuplicatable() {
        System.out.println("You're making a duplicatable API, which is very UNSUGGESTED and DANGEROUS. Use it at your own risk.");
        // We won't allow invoking StandaloneEventAPI.switchAPI
        Method method = StandaloneEventAPI.class.getDeclaredMethod("switchAPI", StandaloneEvent.class, String.class);
        method.setAccessible(true);
        method.invoke(null, new StandardEventRegistry(), "User require duplicatable registry");
    }

    @Override
    public @NotNull String getRegistryName() {
        return "Unique Event Registry";
    }
}
