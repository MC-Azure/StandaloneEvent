// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 License.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.vlouboos.standaloneevent.api.ApiProvider;

@SuppressWarnings("unused")
public class VelocityMain {
    @Inject
    public VelocityMain(ProxyServer server) {
        ApiProvider.injectApi();
    }
}
