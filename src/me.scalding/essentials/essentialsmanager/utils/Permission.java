package essentials.essentialsmanager.utils;

import essentials.Essentials;

public enum Permission {

    COMMAND_LIGHTING(p("lightning")),

    COMMAND_FLY(p("fly")),

    COMMAND_FLY_OTHER(p("fly-other")),

    COMMAND_FEED(p("feed")),

    COMMAND_FEED_OTHER(p("feed-other")),

    COMMAND_HEAL(p("heal")),

    COMMAND_HEAL_OTHER(p("heal-other")),

    WARP_LIST(p("warp-list")),

    WARP(p("warp")),

    SETWARP(p("set-warp"));

    private String permission;

    Permission(String permission) {
        this.permission = p("base-permission-commands") + "." + permission;

    }

    public org.bukkit.permissions.Permission getPermission() {
        return new org.bukkit.permissions.Permission(permission);
    }

    public static String p(String s) {
        return Essentials.getInstance().getConfig().getString("permissions." + s);
    }
}
