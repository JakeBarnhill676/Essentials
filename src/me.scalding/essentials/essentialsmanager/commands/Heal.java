package essentials.essentialsmanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import essentials.essentialsmanager.utils.Messages;
import essentials.essentialsmanager.utils.Permission;

/**
 * Created by Jake on 7/30/2016.
 */
public class Heal extends SubCommand {

    public void onCommand(CommandSender sender, String[] args) {
        Player p = player(sender) ? (Player) sender : null;
        switch (args.length) {
            case 0:
                if (player(sender)) {
                    if (!p.hasPermission(Permission.COMMAND_HEAL.getPermission())) {
                        p.sendMessage(Messages.noPermission());
                        return;
                    }
                    p.setHealth(20.0);
                    p.setFoodLevel(20);
                    p.getActivePotionEffects().forEach(potion -> p.removePotionEffect(potion.getType()));
                    p.sendMessage(Messages.commandHealedYourself());
                    return;
                }
                sender.sendMessage(Messages.onlyUseIngame());
                break;
            case 1:
                if (player(sender)) {
                    if (!p.hasPermission(Permission.COMMAND_HEAL_OTHER.getPermission())) {
                        p.sendMessage(Messages.noPermission());
                        return;
                    }
                    boolean found = false;
                    for (Player all : Bukkit.getOnlinePlayers()) {

                        if (all.getName().equalsIgnoreCase(args[0])) {
                            all.setHealth(20.0);
                            all.setFoodLevel(20);
                            all.getActivePotionEffects().forEach(potion -> all.removePotionEffect(potion.getType()));
                            all.sendMessage(Messages.commandHealedBySomeone(p.getName()));
                            p.sendMessage(Messages.commandHealedSomeone(all.getName()));
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
                        all.setHealth(20.0);
                        all.setFoodLevel(20);
                        all.getActivePotionEffects().forEach(potion -> all.removePotionEffect(potion.getType()));
                        all.sendMessage(Messages.commandHealedBySomeone("CONSOLE"));
                        sender.sendMessage(Messages.commandHealedSomeone(all.getName()));
                        found = true;
                    }
                }
                if(!found) {
                    sender.sendMessage(Messages.invalidPlayer(args[0]));
                }
                return;
            default:
                sender.sendMessage(Messages.wrongSyntax("/heal <player>"));
                break;
        }
    }

    public String commandName() { return "heal"; }


}

