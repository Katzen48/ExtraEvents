package net.chrotos.extraevents.mixins;

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.NonNull;
import space.vectrix.ignite.api.Platform;
import space.vectrix.ignite.api.event.Subscribe;
import space.vectrix.ignite.api.event.platform.PlatformInitializeEvent;

import java.util.logging.Logger;

public class ExtraEventsMod {
    private final Logger logger;
    private final Platform platform;

    @Inject
    public ExtraEventsMod(final Logger logger, final Platform platform) {
        this.logger = logger;
        this.platform = platform;
    }
}
