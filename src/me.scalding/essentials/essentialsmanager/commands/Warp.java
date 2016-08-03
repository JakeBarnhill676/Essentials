package essentials.essentialsmanager.commands;

import essentials.Essentials;
import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;
import essentials.essentialsmanager.utils.warps.WarpManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jake on 8/3/2016.
 */
public class Warp extends SubCommand {


    private WarpManager manager = new WarpManager();

    public void onCommand(CommandSender sender, String[] args) {
        Player p = player(sender) ? (Player) sender : Bukkit.getPlayer("Scalding");
        switch(args.length) {
            case 0:
                    if (!sender.hasPermission(Permission.COMMAND_WARP_LIST.getPermission())) {
                        sender.sendMessage(Messages.noPermission());
                        return;
                    }
                List<String> warps = Essentials.warps.stream().filter(warp -> sender.hasPermission(warpPerm(warp.getName().toLowerCase()))).map(essentials.essentialsmanager.utils.warps.Warp::getName).collect(Collectors.toList());
                StringBuilder builder = new StringBuilder();
                for(int i = 0 ; i < warps.size() ; i++) {
                    builder.append(i+1 == warps.size() ? warps.get(i) : warps.get(i) + ", ");
                }
                sender.sendMessage(Messages.commandWarpList(builder.toString()));
                break;
            case 1:
                if(player(sender)) {
                if(manager.findWarp(args[0])==null) {
                p.sendMessage(Messages.commandWarpInvalid(args[0]));
                    return;
                }
                if(!p.hasPermission(warpPerm(args[0].toLowerCase()))) {
                    p.sendMessage(Messages.noPermission());
                    return;
                }
                essentials.essentialsmanager.utils.warps.Warp warp = manager.findWarp(args[0]);
                p.teleport(warp.getLoc());
                p.sendMessage(Messages.commandWarp(args[0]));
                break;
        }
        sender.sendMessage(Messages.onlyUseIngame());
                break;
            case 2:
                if(manager.findWarp(args[0])==null) {
                    sender.sendMessage(Messages.commandWarpInvalid(args[0]));
                    return;
                }
                if(player(sender)) {
                    if(!p.hasPermission(warpPerm(args[0].toLowerCase()))||!p.hasPermission(Permission.COMMAND_WARP_OTHER.getPermission())) {
                        p.sendMessage(Messages.noPermission());
                        return;
                    }
                }
                essentials.essentialsmanager.utils.warps.Warp warp = manager.findWarp(args[0]);
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(all.getName().equalsIgnoreCase(args[1])) {
                        all.teleport(warp.getLoc());
                        sender.sendMessage(Messages.commandWarpOther(args[0].toUpperCase(), all.getName()));
                        all.sendMessage(Messages.commandWarp(args[0].toUpperCase()));
                        return;
                    }
                }
                sender.sendMessage(Messages.invalidPlayer(args[1]));
                break;
            default:
                p.sendMessage(Messages.wrongSyntax("/warp [warp] <player>"));
                break;
        }

    }

    private String warpPerm(String name) {
        return Essentials.getInstance().getConfig().getString("permissions.warp").replace("<warpname>", name);
    }
}
