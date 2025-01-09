package com.example.dev_project_1.order.service;

import com.example.dev_project_1.order.model.Order;
import com.example.dev_project_1.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        order.setOrderCreatedAt(LocalDateTime.now());
        order.setOrderStatus(Order.OrderStatus.PREPARING);
        return orderRepository.save(order);
    }

    public List<Order> findOrdersByEmail(String customerEmail) {
        return orderRepository.findByCustomerEmail(customerEmail);
    }
}
