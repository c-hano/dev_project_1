package com.example.dev_project_1.delivery.model;

import com.example.dev_project_1.order.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Integer deliveryNumber;
    private String deliveryCompany;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToMany(mappedBy= "deliveryId", cascade = CascadeType.REMOVE)
    private List<Order> orderList;

    public enum DeliveryStatus {
        PREPARING, SHIPPING, DELIVERED
    }
}
