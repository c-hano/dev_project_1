package com.example.dev_project_1.order.model;

import com.example.dev_project_1.common.Address;
import com.example.dev_project_1.common.OrderStatus;
import com.example.dev_project_1.delivery.model.Delivery;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders") // 테이블 이름을 order로 하면 오류가 나서 orders로 변경하였음
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; // 주문 ID

    @Column(nullable = false)
    private String customerEmail; // 고객 이메일

    @Embedded
    private Address address; // 주소 정보 (임베디드)

    private LocalDateTime orderCreatedAt; // 주문 생성 시간
    private Double totalPrice; // 총 금액

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문 상태

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery; // 배송 정보와 1:1 관계

    public Order() {
        this.orderCreatedAt = LocalDateTime.now(); // 생성시 기본 값으로 현재 시간 설정
        this.orderStatus = OrderStatus.ORDERED; // 기본 상태는 "주문 완료"
    }
}
