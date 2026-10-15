package com.example.firstproject.dto;

import com.example.firstproject.entity.Topic;

// [추가 2026-10-08] React(App.js)의 데이터 형태와 맞춘 DTO
// [수정 2026-10-15] 프론트엔드로 이미지 정보를 함께 전달하기 위해 imageUrl 필드 추가
public record TopicDto(Long id, String title, String body, String imageUrl) {

    public static TopicDto from(Topic topic) {
        return new TopicDto(
                topic.getId(),
                topic.getTitle(),
                topic.getBody(),
                topic.getImageUrl() // [추가 2026-10-15] 엔티티의 이미지 경로를 DTO로 매핑
        );
    }
}