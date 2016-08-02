package essentials.essentialsmanager.events.listeners;

import essentials.Essentials;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredListener;

public class BaseEvent implements Listener {



    public BaseEvent() {
        RegisteredListener registeredListener = new RegisteredListener(this, (listener, event) -> onEvent(event), EventPriority.NORMAL, Essentials.getInstance(), false);
        for (HandlerList handler : HandlerList.getHandlerLists()) {
            handler.register(registeredListener);
        }
    }


    private void onEvent(Event e) {
        try {
            SubEvent event = (SubEvent) Essentials.class.getClassLoader().loadClass("essentials.essentialsmanager.events.listeners." + e.getEventName().substring(0, e.getEventName().length()-5)).newInstance();
            event.onEvent(e);
        } catch (Exception ex) {
        }
    }
}
