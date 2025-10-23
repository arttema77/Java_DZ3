package com.example.hellospring;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private static final int DEFAULT_LIMIT = 30;
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
        initializeSampleData();
    }

    private void initializeSampleData() {
        repository.save(new Message("Hello, Spring!", "system"));
        repository.save(new Message("In-memory storage works", "system"));
    }

    public Iterable<Message> getAllMessages() { return repository.findLast(DEFAULT_LIMIT); }
    public Message addMessage(String content, String author) { return repository.save(new Message(content, author)); }
    public Message getById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
    public void clear() { repository.clear(); }
}
