package essentials.essentialsmanager.commands;

import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Jake on 7/30/2016.
 */
public class Lightning extends SubCommand {

    public void onCommand(CommandSender sender,String[] args) {
        Player p = player(sender) ? (Player) sender : null;

        Set<Material> ignore = new HashSet<Material>();
        ignore.add(Material.AIR);
        ignore.add(Material.GRASS);
        ignore.add(Material.VINE);
        ignore.add(Material.CROPS);
        if (player(sender)) {
            if (!p.hasPermission(Permission.COMMAND_LIGHTING.getPermission())) {
                p.sendMessage(Messages.noPermission());
                return;
            }
            switch (args.length) {
                case 0:
                        for (int i = 0; i < 5; i++) { p.getWorld().strikeLightning(p.getTargetBlock(ignore, 50).getLocation()); }
                        Location blockLoc = p.getTargetBlock(ignore, 50).getLocation().clone();
                        for(int x = -3 ; x <= 3; x++) {
                            for(int z = -3 ; z <= 3; z++) {
                                for (int y = -1; y <= 1; y++) {

                                    blockLoc.add(x, y, z);
                                    if (!ignore.contains(blockLoc.getBlock().getType())) {
                                        int random = new Random().nextInt(6) - 1;
                                        if (random == 1) {
                                            blockLoc.getBlock().setType(Material.FIRE);
                                        }
                                    }
                                    blockLoc.subtract(x, y, z);
                                }
                            }
                        }
                        p.sendMessage(Messages.commandLightning());
                    break;
                case 1:
                    try {
                        for (int i = 0; i < 5; i++) { p.getWorld().strikeLightning(p.getTargetBlock(ignore, Integer.parseInt(args[0])).getLocation()); }
                        Location loc = p.getTargetBlock(ignore, Integer.parseInt(args[0])).getLocation().clone();
                        for(int x = -3 ; x <= 3; x++) {
                            for(int z = -3 ; z <= 3; z++) {
                                for (int y = -1; y <= 1; y++) {

                                    loc.add(x, y, z);
                                    if (!ignore.contains(loc.getBlock().getType())) {
                                        int random = new Random().nextInt(4 + 1) - 1;
                                        if (random == 1) {
                                            loc.getBlock().setType(Material.FIRE);
                                        }
                                    }
                                    loc.subtract(x, y, z);
                                }
                            }
                        }
                        p.sendMessage(Messages.commandLightning());
                    } catch (NumberFormatException e) {
                        p.sendMessage(Messages.invalidNumber());
                    }
                    break;
                default:
                    p.sendMessage(Messages.wrongSyntax("/lightning <distance>"));
                    break;
            }
            return;
        }
        sender.sendMessage(Messages.onlyUseIngame());
    }


}
