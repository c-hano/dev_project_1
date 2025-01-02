package project.demo.order_detail;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    //주문 상세 목록 조회
    @GetMapping
    public List<OrderDetailEntity> getOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    //주문 상세 생성
    @PostMapping
    public OrderDetailEntity createOrderDetail(@RequestBody OrderDetailEntity orderDetailEntity) {
        return orderDetailService.createOrderDetail(orderDetailEntity);
    }
}
