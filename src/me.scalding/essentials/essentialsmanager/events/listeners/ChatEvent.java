package essentials.essentialsmanager.events.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Jake on 8/1/2016.
 */
public class ChatEvent extends SubEvent {

    public void onEvent(Event event) {
        if(!isEvent(event, eventName())) {
            Bukkit.broadcast("§c§lEvent error has occurred, please contact Scalding", "mage.error.see");
            return;
        }
        AsyncPlayerChatEvent e = (AsyncPlayerChatEvent) event;
    }

    public String eventName() { return "AsyncPlayerChatEvent"; }
}
