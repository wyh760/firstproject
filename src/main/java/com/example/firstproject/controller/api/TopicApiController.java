package com.example.firstproject.controller.api;

import com.example.firstproject.dto.TopicDto;
import com.example.firstproject.entity.Topic;
import com.example.firstproject.repository.TopicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// [추가 2026-10-08] React용 JSON API (조회, 생성, 수정, 삭제)
@RestController
@RequestMapping("/api/topics")
public class TopicApiController {

    private final TopicRepository topicRepository;

    public TopicApiController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // 목록 조회: GET /api/topics
    @GetMapping
    public List<TopicDto> list() {
        return topicRepository.findAll().stream().map(TopicDto::from).toList();
    }

    // 생성: POST /api/topics   body: {"title":"...","body":"..."}
    @PostMapping
    public ResponseEntity<TopicDto> create(@RequestBody TopicDto dto) {
        Topic saved = topicRepository.save(new Topic(dto.title(), dto.body()));
        return ResponseEntity.status(HttpStatus.CREATED).body(TopicDto.from(saved));
    }

    // 수정: PUT /api/topics/{id}
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody TopicDto dto) {
        return topicRepository.findById(id)
                .map(topic -> {
                    topic.update(dto.title(), dto.body());
                    return ResponseEntity.ok(TopicDto.from(topic));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 삭제: DELETE /api/topics/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!topicRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        topicRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}