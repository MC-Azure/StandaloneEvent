// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent;

import io.github.vlouboos.standaloneevent.exception.DuplicatedRegistryException;
import org.jetbrains.annotations.NotNull;

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
}
