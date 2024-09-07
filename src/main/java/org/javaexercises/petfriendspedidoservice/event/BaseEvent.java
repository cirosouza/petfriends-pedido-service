package org.javaexercises.petfriendspedidoservice.event;

import java.time.LocalDateTime;

public class BaseEvent<T> {

    public final T id;
    private final LocalDateTime timestamp;

    public BaseEvent(T id, LocalDateTime timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public T getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
