package essentials.essentialsmanager.events.listeners;

import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

abstract class SubEvent {

    abstract void onEvent(Event event);

    public abstract String eventName();

    boolean isEvent(Event testedEvent, String wantedEvent) {
        return testedEvent.getEventName().equalsIgnoreCase(wantedEvent);
    }

    List<UUID> muted = new ArrayList<>();

}
