package essentials.essentialsmanager.commands;

import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;
import essentials.essentialsmanager.utils.warps.WarpManager;
import org.bukkit.command.CommandSender;

public class Delwarp extends SubCommand{

    private WarpManager manager = new WarpManager();

    public void onCommand(CommandSender sender, String[] args) {
        if(!sender.hasPermission(Permission.COMMAND_DELWARP.getPermission())) {
        sender.sendMessage(Messages.noPermission());
            return;
        }
            switch(args.length) {
                case 1:
                    if(manager.findWarp(args[0])==null) {
                    sender.sendMessage(Messages.commandDelWarpInvalid(args[0]));
                        return;
                    }
                    sender.sendMessage(Messages.commandDelWarp(args[0]));
                    manager.deleteWarp(args[0]);
                    break;
                default:
                    sender.sendMessage(Messages.wrongSyntax("/delwarp <warp>"));
                    break;
            }
            return;
        }
}
