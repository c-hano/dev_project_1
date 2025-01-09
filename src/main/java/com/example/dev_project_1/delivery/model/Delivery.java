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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId; // 배송 ID

    private String deliveryNumber; // 운송장 번호
    private String deliveryCompany; // 택배사

    @OneToOne
    @JoinColumn(name ="order_id")
    private Order order; //주문 정보와 1:1 관계

    public enum DeliveryStatus {
        PREPARING, SHIPPING, DELIVERED
    }
}
