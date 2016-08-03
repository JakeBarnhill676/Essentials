package essentials.essentialsmanager.utils.warps;

import essentials.Essentials;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Jake on 8/3/2016.
 */
public class Warp {

    private WarpManager manager;

    private Location loc;

    private String name;

    private UUID setter;

    private int id;
    public Warp(Location loc, String name, UUID setter) {
        manager = new WarpManager();
        this.loc = loc;
        this.name = name;
        this.setter = setter;
    }


    public boolean exists() {
        return new File(Essentials.getInstance().getDataFolder() + File.separator + "Warps", name + "." + Integer.toString(id)).exists();
    }

    public boolean create() {
        if(exists()) return false;
        try {
            File file = new File(Essentials.getInstance().getDataFolder() + File.separator + "Warps", name + "." + Integer.toString(id));
            file.createNewFile();
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("location", loc);
            config.set("setter", setter.toString());
            config.set("name", name);
            if(!manager.containsId(id)) {
                Essentials.getInstance().warps.add(this);
            }
            return true;
        }catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public UUID getSetter() {
        return setter;
    }

    public void setSetter(UUID setter) {
        this.setter = setter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public int getId() {
        return id;
    }
}
