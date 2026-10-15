package com.example.firstproject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// [추가 2026-10-08] React용 topics 테이블 엔티티
@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    // [추가 2026-10-15] 데이터베이스에 이미지 경로(URL)를 저장할 컬럼 필드
    private String imageUrl;

    private LocalDateTime createdAt;

    protected Topic() {}

    // [수정 2026-10-15] 게시글 생성 시 이미지 경로(imageUrl)도 함께 전달받아 초기화하도록 수정
    public Topic(String title, String body, String imageUrl) {
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
    }

    // 기존 소스 호환용 생성자
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

    // [추가 2026-10-15] 엔티티에 저장된 이미지 경로를 외부로 가져오기 위한 Getter 메서드
    public String getImageUrl() { return imageUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    // [수정 2026-10-15] 게시글을 수정할 때 이미지 경로도 새로운 값으로 함께 갱신되도록 반영
    public void update(String title, String body, String imageUrl) {
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
    }
}