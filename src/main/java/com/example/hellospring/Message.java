package com.example.hellospring;

import java.util.Objects;

public class Message {
    private Long id;
    private String content;
    private String author;

    public Message() {}
    public Message(String content) { this.content = content; }
    public Message(String content, String author) { this.content = content; this.author = author; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message m = (Message) o;
        return Objects.equals(id, m.id) && Objects.equals(content, m.content) && Objects.equals(author, m.author);
    }
    @Override public int hashCode() { return Objects.hash(id, content, author); }
}
