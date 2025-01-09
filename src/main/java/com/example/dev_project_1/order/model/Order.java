package com.example.dev_project_1.order.model;

import com.example.dev_project_1.delivery.model.Delivery;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String customerEmail;

    @Embedded
    private Address address;

    private LocalDateTime orderCreatedAt;
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;

    public enum OrderStatus {
        PREPARING, SHIPPING, DELIVERED
    }

}
