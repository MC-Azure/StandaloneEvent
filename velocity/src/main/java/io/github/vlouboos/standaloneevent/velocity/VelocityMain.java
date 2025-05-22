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
