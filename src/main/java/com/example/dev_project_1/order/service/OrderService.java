package com.example.dev_project_1.order.service;


import com.example.dev_project_1.order.model.Order;
import com.example.dev_project_1.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

}
