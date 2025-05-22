package io.github.vlouboos.standaloneevent.api;

import org.jetbrains.annotations.ApiStatus;

/**
 * The standard event class of StandaloneEventAPI
 */
@ApiStatus.OverrideOnly
public class Event {
    /**
     * Whether the event is canceled, default {@code false}
     */
    public boolean canceled = false;
}
