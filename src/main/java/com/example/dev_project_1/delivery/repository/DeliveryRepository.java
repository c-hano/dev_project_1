package com.example.dev_project_1.delivery.repository;

import com.example.dev_project_1.delivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
