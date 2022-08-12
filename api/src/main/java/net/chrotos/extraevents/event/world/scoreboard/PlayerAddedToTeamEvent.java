package net.chrotos.extraevents.event.world.scoreboard;

import lombok.Data;
import lombok.NonNull;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scoreboard.Team;

@Data
public class PlayerAddedToTeamEvent extends Event {
    @NonNull
    private static final HandlerList HANDLERS = new HandlerList();

    @NonNull
    private final Team team;
    @NonNull
    private final String entry;

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
