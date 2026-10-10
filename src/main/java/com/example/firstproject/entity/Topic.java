package com.example.firstproject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// [추가 2026-10-08] React용 topics 테이블 엔티티
@jakarta.persistence.Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    private LocalDateTime createdAt;

    protected Topic() {}

    public Topic(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void update(String title, String body) {
        this.title = title;
        this.body = body;
    }
}