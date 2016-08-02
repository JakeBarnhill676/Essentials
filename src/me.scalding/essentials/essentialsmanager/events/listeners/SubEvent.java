package essentials.essentialsmanager.events.listeners;

import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

abstract class SubEvent {

    abstract void onEvent(Event event);

    List<UUID> muted = new ArrayList<>();

}
