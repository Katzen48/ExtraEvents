package net.chrotos.extraevents.event.world.scoreboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

@Data
@AllArgsConstructor
public class ScoreChangedEvent extends Event {
    @NonNull
    private static final HandlerList HANDLERS = new HandlerList();

    @NonNull
    private final Score score;
    private int newScore;

    public Scoreboard getScoreboard() {
        return score.getScoreboard();
    }

    public String getEntry() {
        return score.getEntry();
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
