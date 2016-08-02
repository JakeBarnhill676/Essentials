package essentials.essentialsmanager.events.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.AsyncPlayerChatEvent;

class AsyncPlayerChat extends SubEvent {

    public void onEvent(Event event) {
        AsyncPlayerChatEvent e = (AsyncPlayerChatEvent) event;
        Player p = e.getPlayer();
        if(muted.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage("MUTE MESSAGE HERE");
            return;
        }
    }
}
