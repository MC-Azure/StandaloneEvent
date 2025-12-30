// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 License.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import io.github.vlouboos.standaloneevent.UniqueEventRegistry;

public class ApiProvider {
    @SuppressWarnings("unused")
    public static void injectApi() {
        StandaloneEventAPI.switchAPI(new UniqueEventRegistry(), "Initialization");
    }
}
