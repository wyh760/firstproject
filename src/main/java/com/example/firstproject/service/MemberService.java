package com.example.firstproject.service;

import com.example.firstproject.dto.MemberRequestDto;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원가입 로직
    public Member signup(MemberRequestDto dto) {
        Member member = new Member(
                dto.getMemberId(),
                dto.getPassword(),
                dto.getName(),
                dto.getEmpNo(),
                dto.isHasAuth()
        );
        return memberRepository.save(member);
    }

    // [수정: 2026-10-12 19:46] 로그인 검증 비즈니스 로직 추가
    public Member login(MemberRequestDto dto) {
        Member member = memberRepository.findByMemberId(dto.getMemberId());
        if (member != null && member.getPassword().equals(dto.getPassword())) {
            return member; // 로그인 성공 시 회원 정보 반환
        }
        return null; // 실패 시 null 반환
    }
}