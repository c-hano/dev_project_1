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

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findOrdersByEmail(String email) {
        return orderRepository.findByCustomerEmail(email);
    }
    // 이메일 존재 여부 확인 메서드
    public boolean isCustomerEmailExists(String email) {
        return orderRepository.existsByCustomerEmail(email); // Repository 호출
    }
}
