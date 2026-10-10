package com.example.firstproject.repository;

import com.example.firstproject.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

// [추가 2026-10-08] React용 Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}