package essentials.essentialsmanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;

/**
 * Created by Jake on 7/30/2016.
 */
public class Feed extends SubCommand {

    public void onCommand(CommandSender sender, String[] args) {
        Player p = player(sender) ? (Player) sender : null;
        switch (args.length) {
            case 0:
                if (player(sender)) {
                    if (!p.hasPermission(Permission.COMMAND_FEED.getPermission())) {
                        p.sendMessage(Messages.noPermission());
                        return;
                    }
                    p.setFoodLevel(20);
                    p.sendMessage(Messages.commandFedYourself());
                    return;
                }
                sender.sendMessage(Messages.onlyUseIngame());
                break;
            case 1:
                if (player(sender)) {
                    if (!p.hasPermission(Permission.COMMAND_FEED_OTHER.getPermission())) {
                        p.sendMessage(Messages.noPermission());
                        return;
                    }
                    boolean found = false;
                    for (Player all : Bukkit.getOnlinePlayers()) {

                        if (all.getName().equalsIgnoreCase(args[0])) {
                            all.setFoodLevel(20);
                            all.sendMessage(Messages.commandFedBySomeone(p.getName()));
                            p.sendMessage(Messages.commandFedSomeone(all.getName()));
                            found = true;
                        }
                    }
                    if(!found) {
                        p.sendMessage(Messages.invalidPlayer(args[0]));
                    }
                    return;
                }
                boolean found = false;
                for (Player all : Bukkit.getOnlinePlayers()) {

                    if (all.getName().equalsIgnoreCase(args[0])) {
                        all.setFoodLevel(20);
                        all.sendMessage(Messages.commandFedBySomeone("CONSOLE"));
                        sender.sendMessage(Messages.commandFedSomeone(all.getName()));
                        found = true;
                    }
                }
                if(!found) {
                    sender.sendMessage(Messages.invalidPlayer(args[0]));
                }
                return;
            default:
                sender.sendMessage(Messages.wrongSyntax("/feed <player>"));
                break;
        }
    }

    public String commandName() { return "feed"; }


}
