package com.example.dev_project_1.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // order 클래스에서 사용되도록 선언
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 생성
@NoArgsConstructor // 기본 생성자 생성
@Getter
public class Address {

    @Column(length = 100)
    private String baseAddress;

    @Column(length = 100)
    private String detailAddress;

    @Column(length = 5)
    private String zipCode;
}
