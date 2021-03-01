package io.github.paldiu.obsidian.listener;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public interface EventListener<T extends Event> {
    Logger LOG = Logger.getLogger(EventListener.class.getSimpleName());

    Class<T> getEventType();

    Mono<Void> execute(T event);

    default Mono<Void> handleError(Throwable error) {
        LOG.severe("Unable to process " + getEventType().getSimpleName() + "\n" + error.getMessage());
        return Mono.empty();
    }
}
