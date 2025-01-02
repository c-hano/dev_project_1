package project.demo.order_detail;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    //모든 주문 상세 조회
    public List<OrderDetailEntity> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    //주문 상세 생성

    public OrderDetailEntity createOrderDetail(OrderDetailEntity orderDetailEntity) {
        return orderDetailRepository.save(orderDetailEntity);
    }
}
