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
import java.util.HashSet;

public class UniqueEventRegistry extends StandardEventRegistry {
    private final HashSet<Object> instances = new HashSet<>();

    @Override
    public void register(Object @NotNull ... instances) {
        for (Object instance : instances) {
            if (this.instances.contains(instance)) {
                throw new DuplicatedRegistryException(instance);
            }
        }
        super.register(instances);
    }

    @Override
    public void unregister(Object @NotNull ... instances) {
        Arrays.asList(instances).forEach(this.instances::remove);
        super.unregister(instances);
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
        return super.getRegistryName();
    }
}
