package io.github.vlouboos.standaloneevent;

import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

@AllArgsConstructor
class MethodInstance {
    Object parent;
    Method method;
    long weight;
}