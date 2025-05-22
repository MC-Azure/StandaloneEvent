package io.github.vlouboos.standaloneevent.bukkit;

import io.github.vlouboos.standaloneevent.api.ApiProvider;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class BukkitMain extends JavaPlugin {
    @Override
    public void onLoad() {
        ApiProvider.injectApi();
    }
}
