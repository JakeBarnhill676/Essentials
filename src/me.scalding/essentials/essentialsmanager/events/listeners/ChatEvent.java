package essentials.essentialsmanager.events.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.player.AsyncPlayerChatEvent;

class ChatEvent extends SubEvent {

    public void onEvent(Event event) {
        if(!isEvent(event, eventName())) {
            Bukkit.broadcast("§c§lEvent error has occurred, please contact Scalding", "mage.error.see");
            return;
        }
        AsyncPlayerChatEvent e = (AsyncPlayerChatEvent) event;
        if(muted.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }

    public String eventName() { return "AsyncPlayerChatEvent"; }
}
