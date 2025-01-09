package com.example.dev_project_1.order.model;

import com.example.dev_project_1.delivery.model.Delivery;
import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderId;

    // ....

    @ManyToOne
    private Delivery deliveryId;

}
