package com.example.dev_project_1.delivery.controller;


import com.example.dev_project_1.delivery.model.Delivery;
import com.example.dev_project_1.delivery.service.DeliveryService;
import com.example.dev_project_1.common.Address;
import com.example.dev_project_1.order.model.Order;
import com.example.dev_project_1.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final OrderService orderService;

    public DeliveryController(DeliveryService deliveryService, OrderService orderService) {
        this.deliveryService = deliveryService;
        this.orderService = orderService;
    }

    //테스트용 코드입니다.
    @GetMapping("/create-sample")
    public String createSampleData() {
        Order order = new Order();
        order.setCustomerEmail("test@example.com");
        order.setAddress(new Address("서울시 강남구", "123-45", "06236"));
        order.setTotalPrice(50000.0);

        orderService.saveOrder(order);
        deliveryService.createDelivery(order);

        return "redirect:/delivery/1";
    }


    // 배송 정보 페이지
    @GetMapping("/{deliveryId}")
    public String deliveryInfoPage(@PathVariable Long deliveryId, Model model) {
        Delivery delivery = deliveryService.getDeliveryById(deliveryId); // 서비스 계층을 통해 배송 정보 조회

        model.addAttribute("delivery", delivery);
        model.addAttribute("deliveryStatus", delivery.getOrder().getOrderStatus().getStatus());
        return "delivery"; // 배송 정보 HTML 반환
    }
}


