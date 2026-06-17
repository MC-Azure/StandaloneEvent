// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 License.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.api;

import io.github.vlouboos.standaloneevent.StandardEventRegistry;
import io.github.vlouboos.standaloneevent.UniqueEventRegistry;

public class ApiProvider {
    @SuppressWarnings("unused")
    public static void injectApi(boolean unique) {
        if (!unique) {
            System.out.println("You're making a duplicatable API, which is very UNSUGGESTED and DANGEROUS. Use it at your own risk.");
        }
        StandaloneEventAPI.switchAPI(unique ? new UniqueEventRegistry() : new StandardEventRegistry(), "Initialization");
    }
}
