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
    private Integer id;

    private Integer deliveryNumber;
    private String deliveryCompany;


    //deliveryId 하나 당 여러개의 Order 정보가 필요하다
    @OneToMany(mappedBy= "deliveryId", cascade = CascadeType.REMOVE)
    //해당 Order이 사라지면 그에 대응하는 deliveryId도 사라져야 한다. 이렇게 하는게 맞는지..?
    private List<Order> orderList;

}
