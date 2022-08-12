package net.chrotos.extraevents.mixin.core;

import net.chrotos.extraevents.event.world.scoreboard.ScoreChangedEvent;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Score;
import org.bukkit.Bukkit;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Score.class)
public abstract class MixinScore {
    @Shadow
    @Final
    private Objective objective;

    @Shadow
    @Final
    private String owner;

    @Inject(method = "setScore", at = @At("HEAD"))
    protected void onSetScore(int score, CallbackInfo ci) {
        if (objective == null) {
            return;
        }

        if (Bukkit.getScoreboardManager() == null) {
            return;
        }

        org.bukkit.scoreboard.Objective bukkitObjective = Bukkit.getScoreboardManager().getMainScoreboard().getObjective(objective.getName());
        if (bukkitObjective == null) {
            return;
        }

        Bukkit.getPluginManager().callEvent(new ScoreChangedEvent(bukkitObjective.getScore(owner), score));
    }
}
