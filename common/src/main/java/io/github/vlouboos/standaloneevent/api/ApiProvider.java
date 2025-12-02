// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import io.github.vlouboos.standaloneevent.StandardEventRegistry;
import io.github.vlouboos.standaloneevent.UniqueEventRegistry;

public class ApiProvider {
    public static void injectApi() {
        StandaloneEventAPI.init(new UniqueEventRegistry());
    }

    public static void makeDuplicatable() {
        StandaloneEventAPI.duplicate(new StandardEventRegistry());
    }
}
