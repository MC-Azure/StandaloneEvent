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
