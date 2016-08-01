package essentials.essentialsmanager.events.listeners;

import essentials.Essentials;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 8/1/2016.
 */
public class BaseEvent implements Listener {

    public List<SubEvent> events = new ArrayList();



    public BaseEvent() {
        RegisteredListener registeredListener = new RegisteredListener(this, (listener, event) -> onEvent(event), EventPriority.NORMAL, Essentials.getInstance(), false);
        for (HandlerList handler : HandlerList.getHandlerLists()) {
            handler.register(registeredListener);
        }
        events.add(new ChatEvent());
    }


    public void onEvent(org.bukkit.event.Event e) {
        for(SubEvent event : events) {
            if(e.getEventName().equalsIgnoreCase(event.eventName())) {
                event.onEvent(e);
            }
        }
    }
}
