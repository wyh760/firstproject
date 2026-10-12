package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // [수정: 2026-10-12 19:46] 로그인 시 아이디로 회원 정보를 조회하기 위한 메서드 추가
    Member findByMemberId(String memberId);
}