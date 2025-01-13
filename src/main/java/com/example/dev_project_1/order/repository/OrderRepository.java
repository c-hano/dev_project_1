package com.example.dev_project_1.order.repository;


import com.example.dev_project_1.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerEmail(String customerEmail);

    boolean existsByCustomerEmail(String customerEmail);
}
