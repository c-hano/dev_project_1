package com.example.dev_project_1.order.model;

import com.example.dev_project_1.delivery.model.Delivery;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long orderId;
    private String customerEmail;
    private String baseAddress;
    private Integer zipCode;
    private LocalDateTime orderCreatedAt;
    private Double totalPrice;
    private String orderStatus;
    @OneToOne
    private Delivery delivery;

    public enum OrderStatus {
        PREPARING, SHIPPING, DELIVERED
    }

}
