// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
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
