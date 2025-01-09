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

    // 배송 상태 확인 페이지
    @GetMapping
    public String deliveryInfoPage(@RequestParam Long deliveryId, Model model) {
        // deliveryId를 통해 배송 정보를 조회
        Delivery delivery = deliveryService.findById(deliveryId);
        model.addAttribute("delivery", delivery);
        return "delivery";
    }
}


