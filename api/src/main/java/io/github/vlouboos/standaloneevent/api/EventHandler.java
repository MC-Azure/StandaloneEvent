// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The identity of an event listener instance.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventHandler {
    /**
     * To determine the order of instances, smaller numbers mean prior executions, default {@code Long.MAX_VALUE}.
     *
     * @return The priority of the instance.
     */
    long value() default Long.MAX_VALUE;
}
