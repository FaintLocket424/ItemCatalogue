package org.example.faintlocket.blockTracking;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.faintlocket.blockTracking.commands.AdvancementsCommand;

public class BlockTracking extends JavaPlugin {

    private static final String pluginName = "BlockTracking";
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        LOGGER = getLogger();
        LOGGER.info("Starting %s".formatted(pluginName));

        AdvancementsCommand.RegisterCommand(this);
        LOGGER.info("Registered commands");

        DatapackGenerator.GenerateJSON(getServer().getConsoleSender(), this);
        LOGGER.info("Generated JSON");
    }
}
