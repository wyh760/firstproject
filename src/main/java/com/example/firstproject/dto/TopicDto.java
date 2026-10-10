package com.example.firstproject.dto;

import com.example.firstproject.entity.Topic;

// [추가 2026-10-08] React(App.js)의 {id, title, body} 형태와 맞춘 DTO
public record TopicDto(Long id, String title, String body) {

    public static TopicDto from(Topic topic) {
        return new TopicDto(topic.getId(), topic.getTitle(), topic.getBody());
    }
}