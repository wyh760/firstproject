package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberRequestDto;
import com.example.firstproject.entity.Member;
import com.example.firstproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*") // 리액트와의 원활한 통신을 위한 CORS 허용
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 회원가입 요청 처리 (POST /api/members/signup)
    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody MemberRequestDto requestDto) {
        try {
            Member savedMember = memberService.signup(requestDto);
            return ResponseEntity.ok(savedMember);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // [수정: 2026-10-12 19:46] DB 연동 로그인 요청 처리 (POST /api/members/login)
    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody MemberRequestDto requestDto) {
        try {
            Member member = memberService.login(requestDto);
            if (member != null) {
                return ResponseEntity.ok(member); // 로그인 성공 (200 OK + 회원 정보)
            } else {
                return ResponseEntity.status(401).build(); // 인증 실패 (401 Unauthorized)
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}