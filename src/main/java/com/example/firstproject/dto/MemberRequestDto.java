package com.example.firstproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {
    private String memberId; // 아이디
    private String password; // 비밀번호
    private String name;     // 이름
    private String empNo;    // 사번
    private boolean hasAuth; // 메뉴 생성 및 관리 권한 여부
}
