package com.example.dev_project_1.delivery.service;

import com.example.dev_project_1.delivery.model.Delivery;
import com.example.dev_project_1.delivery.repository.DeliveryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Scheduled(cron = "0 0 14 * * ?")
    //14시에 배송 상품들 일괄처리
    public void updateDeliveryStatus() {
        var deliveries = deliveryRepository.findAll();
        deliveries.forEach(delivery -> {
            if (delivery.getStatus() == Delivery.DeliveryStatus.PREPARING) {
                delivery.setStatus(Delivery.DeliveryStatus.SHIPPING);
                deliveryRepository.save(delivery);
            }
        });
    }
}

