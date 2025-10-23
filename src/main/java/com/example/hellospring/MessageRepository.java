package com.example.hellospring;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MessageRepository {
    private final Map<Long, Message> storage = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Message save(Message message) {
        if (message.getId() == null) message.setId(idCounter.incrementAndGet());
        storage.put(message.getId(), message);
        return message;
    }

    public Message findById(Long id) { return storage.get(id); }

    public Iterable<Message> findAll() { return new ArrayList<>(storage.values()); }

    public void deleteById(Long id) { storage.remove(id); }

    public void clear() { storage.clear(); }

    public List<Message> findLast(int limit) {
        return storage.values().stream()
                .sorted(Comparator.comparing(Message::getId))
                .skip(Math.max(0, storage.size() - limit))
                .toList();
    }
}
