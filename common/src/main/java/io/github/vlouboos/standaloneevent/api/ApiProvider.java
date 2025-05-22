package io.github.vlouboos.standaloneevent.api;

import io.github.vlouboos.standaloneevent.EventRegistry;

public class ApiProvider {
    public static void injectApi() {
        StandaloneEventAPI.init(new EventRegistry());
    }
}
