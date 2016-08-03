package essentials.essentialsmanager.commands;

import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;
import essentials.essentialsmanager.utils.warps.WarpManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setwarp extends SubCommand {

    private WarpManager manager = new WarpManager();

    public void onCommand(CommandSender sender, String[] args) {
        Player p = player(sender) ? (Player) sender : Bukkit.getPlayer("Scalding");
        if(player(sender)) {
            if(!p.hasPermission(Permission.COMMAND_SETWARP.getPermission())) { p.sendMessage(Messages.noPermission()); return; }
            switch(args.length) {
                case 1:
                    if(manager.containsName(args[0])) {
                        p.sendMessage(Messages.commandSetWarpTaken(args[0]));
                        return;
                    }
                    if(args[0].length() < 4) {
                        p.sendMessage(Messages.commandSetWarpShort(args[0]));
                        return;
                    }
                    manager.createWarp(p, args[0]);
                    p.sendMessage(Messages.commandSetWarp(args[0], p.getLocation()));
                    break;
                default:
                    p.sendMessage(Messages.wrongSyntax("/setwarp <name>"));
                    break;
            }
            return;
        }
        sender.sendMessage(Messages.onlyUseIngame());
    }
}
