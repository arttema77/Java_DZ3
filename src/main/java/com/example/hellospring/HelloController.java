package com.example.hellospring;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {
    private final MessageService service;

    public HelloController(MessageService service) { this.service = service; }

    @GetMapping("/")
    public String hello() { return "Hello, World!"; }

    @GetMapping("/messages")
    public Iterable<Message> getMessages() { return service.getAllMessages(); }

    public record MessageCreateRequest(String content, String author) {}
    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Message postMessage(@RequestBody MessageCreateRequest req) {
        return service.addMessage(req.content(), req.author());
    }
}
