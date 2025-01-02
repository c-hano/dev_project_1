package project.demo.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //주문 목록 조회
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    //주문 생성
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }
}
