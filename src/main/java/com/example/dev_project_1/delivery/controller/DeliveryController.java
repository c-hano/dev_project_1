package com.example.dev_project_1.delivery.controller;


import com.example.dev_project_1.delivery.model.Delivery;
import com.example.dev_project_1.delivery.service.DeliveryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    // 배송 정보 페이지
    @GetMapping("/{deliveryId}")
    public String deliveryInfoPage(@PathVariable Long deliveryId, Model model) {
        Delivery delivery = deliveryService.getDeliveryById(deliveryId); // 서비스 계층을 통해 배송 정보 조회
        String deliveryStatus = deliveryService.getDeliveryStatus(delivery); // 배송 상태 조회

        model.addAttribute("delivery", delivery);
        model.addAttribute("deliveryStatus", deliveryStatus);
        return "delivery"; // 배송 정보 HTML 반환
    }
}


