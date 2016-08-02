package essentials.essentialsmanager.commands;

import org.bukkit.command.CommandSender;
import essentials.essentialsmanager.utils.Messages;

/**
 * Created by Jake on 7/30/2016.
 */
public class Help extends SubCommand {

    public void onCommand(CommandSender sender, String[] args) {
        for(String string : Messages.helpMessage()) {
            sender.sendMessage(string);
        }
    }

}
