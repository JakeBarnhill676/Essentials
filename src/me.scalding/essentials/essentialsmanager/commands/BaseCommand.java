package essentials.essentialsmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
public class BaseCommand implements CommandExecutor {

    private List<SubCommand> commands = new ArrayList<>();

    public BaseCommand() {
        commands.add(new Lightning());
        commands.add(new Heal());
        commands.add(new Feed());
        commands.add(new Help());
        commands.add(new Fly());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        commands.forEach(command -> {
            if(command.commandName().equalsIgnoreCase(cmd.getName())) {
                command.onCommand(sender, args);
            }
        });
        return true;
    }



}
