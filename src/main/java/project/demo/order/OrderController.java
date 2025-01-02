package project.demo.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.demo.product.ProductEntity;
import project.demo.product.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    //주문 목록 조회
    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    //주문 생성
    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return orderService.createOrder(order);
    }
}
