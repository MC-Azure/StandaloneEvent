// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 Licence.
// See https://spdx.org/licenses/BSD-3-Clause.html
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
