package com.example.dev_project_1.common.login.buyer.service;


import com.example.dev_project_1.order.model.Order;
import com.example.dev_project_1.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLoginService {
    private final OrderRepository orderRepository;

    public List<Order> findOrdersByEmail(String email) {
        return orderRepository.findByCustomerEmail(email);
    }
    // 이메일 존재 여부 확인 메서드
    public boolean isCustomerEmailExists(String email) {
        return orderRepository.existsByCustomerEmail(email); // Repository 호출
    }
}
