package essentials;

import essentials.essentialsmanager.commands.BaseCommand;
import essentials.essentialsmanager.events.listeners.BaseEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Map;

public final class Essentials extends JavaPlugin{

    private static Essentials instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        createFiles();
        instance = this;
        for(Map.Entry<String, Map<String, Object>> map : getDescription().getCommands().entrySet()) {
            getCommand(map.getKey()).setExecutor(new BaseCommand());
        }
        Bukkit.getPluginManager().registerEvents(new BaseEvent(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Essentials getInstance() {
        return instance;
    }

    public static File getHelp() {
        return new File("plugins" + File.separator + "Essentials", "help.yml");
    }

    private void createFiles() {
        File help = new File("plugins" + File.separator + "Essentials", "help.yml");
        if(!help.exists()) { saveResource("help.yml", false); }
    }
}
