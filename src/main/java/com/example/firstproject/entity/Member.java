package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // DB 자동 증가 PK

    @Column(nullable = false, unique = true)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String empNo;

    @Column(nullable = false)
    private boolean hasAuth;

    // DTO 데이터를 엔티티로 변환하기 위한 생성자
    public Member(String memberId, String password, String name, String empNo, boolean hasAuth) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.empNo = empNo;
        this.hasAuth = hasAuth;
    }
}
