package io.github.vlouboos.standaloneevent.bungee;

import io.github.vlouboos.standaloneevent.api.ApiProvider;
import net.md_5.bungee.api.plugin.Plugin;

@SuppressWarnings("unused")
public class BungeeMain extends Plugin {
    @Override
    public void onLoad() {
        ApiProvider.injectApi();
    }
}
