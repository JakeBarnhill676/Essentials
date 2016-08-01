package essentials.essentialsmanager.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jake on 7/30/2016.
 */
public abstract class SubCommand {

    public abstract void onCommand(CommandSender sender, String[] args);

    public abstract String commandName();

    public boolean player(CommandSender sender) {
        return sender instanceof Player;
    }

    public static List<UUID> flightToggled = new ArrayList();
}
