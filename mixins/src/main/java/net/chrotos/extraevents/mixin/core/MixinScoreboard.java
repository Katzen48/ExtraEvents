package net.chrotos.extraevents.mixin.core;

import net.chrotos.extraevents.event.world.scoreboard.PlayerAddedToTeamEvent;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Team;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Scoreboard.class)
public abstract class MixinScoreboard {
    @Inject(method = "addPlayerToTeam", at = @At("HEAD"))
    protected void onAddPlayerToTeam(String entry, PlayerTeam team, CallbackInfoReturnable<Boolean> info) {
        if (!info.getReturnValue()) {
            return;
        }

        if (Bukkit.getScoreboardManager() == null) {
            return;
        }

        Team bukkitTeam = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(team.getName());
        if (bukkitTeam == null) {
            return;
        }

        Bukkit.getPluginManager().callEvent(new PlayerAddedToTeamEvent(bukkitTeam, entry));
    }
}
