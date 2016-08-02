package essentials.essentialsmanager.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

abstract class SubCommand {

    public abstract void onCommand(CommandSender sender, String[] args);

    boolean player(CommandSender sender) {
        return sender instanceof Player;
    }

    static List<UUID> flightToggled = new ArrayList<>();

}
