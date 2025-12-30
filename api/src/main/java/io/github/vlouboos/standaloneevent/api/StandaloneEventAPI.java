// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * To prevent the size of this api from getting too big, actual inherits are not embedded.
 */
public final class StandaloneEventAPI {
    /**
     * -- GETTER --
     * Get the API of StandaloneEvent
     */
    @Getter
    private static StandaloneEvent api;

    // No constructor
    @ApiStatus.Internal
    private StandaloneEventAPI() {

    }

    // package-private
    @ApiStatus.Internal
    @SuppressWarnings("all")
    static void switchAPI(@NotNull StandaloneEvent api, @NotNull String reason) {
        if (StandaloneEventAPI.api == null) {
            System.out.printf("[StandaloneEventAPI] Switched to %s: %s\n", api.getRegistryName(), reason);
        } else {
            System.out.printf("[StandaloneEventAPI] Switched to %s from %s: %s\n", api.getRegistryName(), StandaloneEventAPI.api.getRegistryName(), reason);
        }
        StandaloneEventAPI.api = api;
    }
}
