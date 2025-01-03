package project.demo.order;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // 1. 모든 주문 조회
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // 2. 새로운 주문 생성
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    // 3. 주문 삭제
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
