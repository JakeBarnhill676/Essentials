package essentials.essentialsmanager.utils;

import essentials.Essentials;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.stream.Collectors;

/**
 * Created by Jake on 7/30/2016.
 */
public class Messages {

    private static String prefix = ChatColor.translateAlternateColorCodes('&', Essentials.getInstance().getConfig().getString("messages.prefix"));
    /**
     * Retrieves a message out of the config
     *
     * @param path the message to get from the config
     * @return the requested string from the config
     */

    private static String getMessage(String path) { return prefix + ChatColor.translateAlternateColorCodes('&', Essentials.getInstance().getConfig().getString("messages." + path)); }

    public static String[] helpMessage() {
        return YamlConfiguration.loadConfiguration(Essentials.getHelp()).getStringList("message").stream().map(string -> ChatColor.translateAlternateColorCodes('&', string)).collect(Collectors.toList()).toArray(new String[]{});
    }

    public static String onlyUseIngame() { return getMessage("onlyIngame"); }

    public static String onlyUseFromConsole() { return getMessage("onlyConsole"); }

    public static String noPermission() { return getMessage("noPermission"); }

    public static String wrongSyntax(String usage) { return getMessage("wrongSyntax").replace("%usage%", usage); }

    public static String invalidNumber() { return getMessage("invalidNumber"); }

    public static String invalidPlayer(String name) {return getMessage("invalidPlayer").replace("%player%", name); }

    public static String commandLightning() { return getMessage("commands.lightning"); }

    public static String commandFedYourself() { return getMessage("commands.fedYourself"); }

    public static String commandFedSomeone(String fed) { return getMessage("commands.fedSomeone").replace("%fedPerson%", fed); }

    public static String commandFedBySomeone(String feeder) { return getMessage("commands.fedBySomeone").replace("%feeder%", feeder); }

    public static String commandHealedYourself() { return getMessage("commands.healedYourself"); }

    public static String commandHealedSomeone(String healed) { return getMessage("commands.healedSomeone").replace("%healedPerson%", healed); }

    public static String commandHealedBySomeone(String healer) { return getMessage("commands.healedBySomeone").replace("%healer%", healer); }

    public static String commandFlightDisabled() { return getMessage("commands.flightDisabled"); }

    public static String commandFlightEnabled() { return getMessage("commands.flightEnabled"); }

    public static String commandFlightDisabledBySomeone(String disabler) { return getMessage("commands.flightDisabledBySomeone").replace("%disabler%", disabler); }

    public static String commandFlightEnabledBySomeone(String enabler) { return getMessage("commands.flightEnabledBySomeone").replace("%enabler%", enabler); }

    public static String commandFlightDisablingSomeone(String disabled) { return getMessage("commands.flightDisablingSomeone").replace("%disabled%", disabled); }

    public static String commandFlightEnablingSomeone(String enabled) { return getMessage("commands.flightEnablingSomeone").replace("%enabled%", enabled); }

    public static String commandSetWarpTaken(String name) { return getMessage("commands.setwarp-taken").replace("%name%", name); }

    public static String commandSetWarpShort(String name) { return getMessage("commands.setwarp-short").replace("%name%", name);}

    public static String commandSetWarp(String name, Location loc) { return getMessage("commands.setwarp").replace("%name%", name).replace("%x%",Double.toString(loc.getX())).replace("%y%",Double.toString(loc.getY())).replace("%z%",Double.toString(loc.getZ())).replace("%world%", loc.getWorld().getName()); }

    public static String commandWarpInvalid(String name) { return getMessage("commands.invalid-warp").replace("%name%", name); }

    public static String commandWarp(String name) {return getMessage("commands.warp").replace("%warp%", name); }

    public static String commandWarpOther(String warp, String player) {return getMessage("commands.warped-someone").replace("%player%", player).replace("%warp%", warp); }

    public static String commandWarpList(String warps) { return getMessage("commands.warps").replace("%warps%", warps);}

    public static String commandDelWarp(String name) { return getMessage("commands.delwarp").replace("%name%", name); }

    public static String commandDelWarpInvalid(String name) { return getMessage("commands.delwarp-invalid").replace("%name%", name); }
}
