package essentials.essentialsmanager.utils;

/**
 * Created by Jake on 7/30/2016.
 */
public enum Permission {

    COMMAND_LIGHTING("lightning"),

    COMMAND_FLY("fly"),

    COMMAND_FLY_OTHER("fly.other"),

    COMMAND_FEED("feed"),

    COMMAND_FEED_OTHER("feed.other"),

    COMMAND_HEAL("heal"),

    COMMAND_HEAL_OTHER("heal.other");

    private String permission;

    Permission(String permission) {
        this.permission = "mage.use." + permission;

    }

    public org.bukkit.permissions.Permission getPermission() {
        return new org.bukkit.permissions.Permission(permission);
    }
}
