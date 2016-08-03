package essentials.essentialsmanager.commands;

import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly extends SubCommand {
    public void onCommand(CommandSender sender, String[] args) {
        Player p = player(sender) ? (Player) sender : Bukkit.getPlayer("Scalding");
        switch(args.length) {
            case 0:
                if(player(sender)) {

                    if (!p.hasPermission(Permission.COMMAND_FLY.getPermission())) {
                        p.sendMessage(Messages.noPermission());
                        return;
                    }
                    if(flightToggled.contains(p.getUniqueId())) {
                        flightToggled.remove(p.getUniqueId());
                        p.setAllowFlight(false);
                        p.sendMessage(Messages.commandFlightDisabled());
                        return;
                    }
                    p.setAllowFlight(true);
                    p.sendMessage(Messages.commandFlightEnabled());
                    flightToggled.add(p.getUniqueId());
                    return;
                }
                sender.sendMessage(Messages.onlyUseIngame());
                break;
            case 1:
                if(player(sender)) {
                if(!p.hasPermission(Permission.COMMAND_FLY_OTHER.getPermission())) {
                    p.sendMessage(Messages.noPermission());
                    return;
                }
                }
                boolean worked = false;
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(all.getName().equalsIgnoreCase(args[0])) {
                        worked = true;
                        if(flightToggled.contains(all.getUniqueId())) {
                            flightToggled.remove(all.getUniqueId());
                            all.setAllowFlight(false);
                            all.sendMessage(Messages.commandFlightDisabledBySomeone(player(sender) ? p.getName() : "CONSOLE"));
                            sender.sendMessage(Messages.commandFlightDisablingSomeone(all.getName()));
                            return;
                        }
                        flightToggled.add(all.getUniqueId());
                        all.setAllowFlight(true);
                        all.sendMessage(Messages.commandFlightEnabledBySomeone(player(sender) ? p.getName() : "CONSOLE"));
                        sender.sendMessage(Messages.commandFlightEnablingSomeone(all.getName()));
                    }
                }
                if(!worked) {
                    sender.sendMessage(Messages.invalidPlayer(args[0]));
                }
                break;
            default:
                sender.sendMessage(Messages.wrongSyntax("/fly <player>"));
                break;
        }
    }

}
