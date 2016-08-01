package essentials.essentialsmanager.events.listeners;

import org.bukkit.event.Event;

/**
 * Created by Jake on 8/1/2016.
 */
public abstract class SubEvent {

    public abstract void onEvent(Event event);

    public abstract String eventName();

    public boolean isEvent(Event testedEvent, String wantedEvent) {
        return testedEvent.getEventName().equalsIgnoreCase(wantedEvent);
    }

}
