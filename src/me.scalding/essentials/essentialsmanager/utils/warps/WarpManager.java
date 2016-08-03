package essentials.essentialsmanager.utils.warps;

import essentials.Essentials;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static essentials.Essentials.warps;

/**
 * Created by Jake on 8/3/2016.
 */
public class WarpManager {

    public boolean containsId(int id) {
        for(Warp warp : Essentials.getInstance().warps) {
            if(warp.getId()==id) return true;
        }
        return false;
    }

    public boolean containsName(String name) {
        for(Warp warp : Essentials.getInstance().warps) {
            if(warp.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public int newId() {
        Random random = new Random();
        int id = random.nextInt(15000);
        while(containsId(id)) {
            id = random.nextInt(15000);
        }
        return id;
    }

    public void createWarp(Player p, String name) {
        try {
            Warp warp = new Warp(p.getLocation(), name, p.getUniqueId());
            if (warp.exists()) return;
            warp.create();
        }catch(IOException ex) {
        }
    }

    public Warp findWarp(String name) {
        for(Warp warp : Essentials.getInstance().warps) {
            if(warp.getName().equalsIgnoreCase(name)) {
                return warp;
            }
        }
        return null;
    }

    public void deleteWarp(String name) {

            Warp warp = findWarp(name);
            warps.forEach(all -> {
                if (all.getId() == warp.getId()) {
                    synchronized ("sync delete") {
                        File file = new File(Essentials.getInstance().getDataFolder() + File.separator + "Warps", all.getName() + "." + all.getId() + ".yml");
                        file.delete();
                    }
                    warps.remove(all);
                }
            });

    }
}
