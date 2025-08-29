// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
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
