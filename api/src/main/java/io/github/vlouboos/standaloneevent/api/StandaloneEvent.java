// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * The API of StandaloneEvent
 */
@ApiStatus.NonExtendable
public interface StandaloneEvent {
    /**
     * Register some event listeners.
     *
     * @param instances The {@code Object/Class} to register.
     *
     * @apiNote When an {@link Object} is registered, its dynamic handlers are registered.
     * When a {@link Class} is registered, its static handlers are registered.
     */
    void register(Object @NotNull ... instances);

    /**
     * Unregister some event listeners.
     *
     * @param instances The {@code Object/Class} to unregister.
     *
     * @apiNote When an {@link Object} is unregistered, its dynamic handlers are unregistered.
     * When a {@link Class} is unregistered, its static handlers are unregistered.
     */
    void unregister(Object @NotNull ... instances);

    /**
     * Fire a specific event.
     * @param event The Event to be fired
     */
    void call(@NotNull Event event);

    /**
     * Check if an object or a class is already in registry
     * @param instance The object or class to check
     */
    boolean isRegistered(@NotNull Object instance);

    /**
     * Make the registry support duplicated elements
     * @apiNote This will reinitialize the whole registry, which will delete all your registration
     */
    void makeDuplicatable();
}
