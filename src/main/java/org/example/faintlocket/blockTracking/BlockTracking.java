package org.example.faintlocket.blockTracking;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockTracking extends JavaPlugin implements Listener {

    private static final String pluginName = "BlockTracking";

    @Override
    public void onEnable() {
        getLogger().info("Starting %s".formatted(pluginName));
        
        AdvancementsCommand.RegisterCommand(this);
        getLogger().info("Registered commands");

        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Registered listeners");

        DatapackGenerator.GenerateJSON(getServer().getConsoleSender(), this);
        getLogger().info("Generated JSON");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!event.getPlayer().getName().equals("FaintLocket424")) {
            return;
        }

        NamespacedKey key = new NamespacedKey(DatapackGenerator.GetDatapackNamespace(), "root");
        getServer().dispatchCommand(getServer().getConsoleSender(),
            "advancement grant %s from %s".formatted(event.getPlayer().getName(), key.key())
        );
    }

}
