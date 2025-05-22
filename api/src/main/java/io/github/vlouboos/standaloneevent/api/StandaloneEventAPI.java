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
