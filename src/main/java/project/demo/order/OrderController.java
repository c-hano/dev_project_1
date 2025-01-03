package project.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.demo.product.ProductEntity;
import project.demo.product.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 1. HTML 페이지 반환
    @GetMapping
    public String getOrdersPage(Model model) {
        List<OrderEntity> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order"; // order.html 템플릿 렌더링
    }

    // 2. 새로운 주문 생성 (HTML에서 처리)
    @PostMapping
    public String createOrder(OrderEntity order, Model model) {
        orderService.createOrder(order);
        model.addAttribute("orders", orderService.getAllOrders());
        return "order"; // order.html 템플릿 업데이트
    }

    // 3. 주문 삭제 (HTML에서 처리)
    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id, Model model) {
        orderService.deleteOrder(id);
        model.addAttribute("orders", orderService.getAllOrders());
        return "order"; // order.html 템플릿 업데이트
    }
}

