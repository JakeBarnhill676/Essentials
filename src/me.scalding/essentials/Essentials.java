package essentials;

import essentials.essentialsmanager.commands.BaseCommand;
import essentials.essentialsmanager.events.listeners.BaseEvent;
import essentials.essentialsmanager.utils.warps.Warp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class Essentials extends JavaPlugin{

    private static Essentials instance;

    public static List<Warp> warps;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        createFiles();
        warps = new ArrayList<>();
        for(File warpFile : new File(this.getDataFolder() + File.separator + "Warps").listFiles()) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(warpFile);
            warps.add(new Warp((Location) config.get("location"), config.getString("name"), UUID.fromString(config.getString("setter"))));
        }
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
        File warps = new File(getDataFolder() + File.separator + "Warps");
        if(!warps.exists()) {
            warps.mkdirs();
        }
    }
}
