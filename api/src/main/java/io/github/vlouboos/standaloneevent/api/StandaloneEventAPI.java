// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

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
    @ApiStatus.Internal
    private static boolean loaded = false;

    // No constructor
    @ApiStatus.Internal
    private StandaloneEventAPI() {

    }

    // package-private
    @ApiStatus.Internal
    static void init(StandaloneEvent api) {
        if (loaded) return;
        StandaloneEventAPI.api = api;
        loaded = true;
    }
}
