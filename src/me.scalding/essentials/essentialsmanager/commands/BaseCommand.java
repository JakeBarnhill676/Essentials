package essentials.essentialsmanager.commands;

import essentials.Essentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            SubCommand sub = (SubCommand) Essentials.class.getClassLoader().loadClass("essentials.essentialsmanager.commands." + cmd.getName().substring(0, 1).toUpperCase() + cmd.getName().substring(1)).newInstance();
            sub.onCommand(sender, args);
        }catch(Exception e) {
        }
        return true;
    }

}
