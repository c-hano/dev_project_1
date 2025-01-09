package com.example.dev_project_1.delivery.service;

import com.example.dev_project_1.delivery.model.Delivery;
import com.example.dev_project_1.delivery.repository.DeliveryRepository;
import com.example.dev_project_1.order.model.Order;
import com.example.dev_project_1.order.model.OrderStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    // 특정 배송 ID로 배송 정보 조회
    public Delivery getDeliveryById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid delivery ID: " + deliveryId));
    }

    // 배송 상태 가져오기
    public String getDeliveryStatus(Delivery delivery) {
        return delivery.getOrder().getOrderStatus().getStatus();
    }

    // 운송장 번호 생성 : 랜덤한 12개의 숫자 생성
    public String generateRandomTrackingNumber() {
        Random random = new Random();
        StringBuilder trackingNumber = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            trackingNumber.append(random.nextInt(10)); // 0~9 사이의 숫자 추가
        }
        return trackingNumber.toString();
    }

    // 운송 회사 생성 : 랜덤한 두 글자의 한글 + 택배를 생성하는 메서드
    public String generateCourierName() {
        Random random = new Random();
        char firstChar = (char) (random.nextInt(11172) + 44032); // 유니코드 한글 범위: 0xAC00 ~ 0xD7A3
        char secondChar = (char) (random.nextInt(11172) + 44032); // 두 번째 글자
        return "" + firstChar + secondChar + "택배"; // 랜덤 두 글자 + "택배"
    }

    // 배송 정보 생성 및 저장
    public Delivery createDelivery(Order order) {
        Delivery delivery = new Delivery();
        delivery.setDeliveryNumber(generateRandomTrackingNumber()); // 운송장 번호 설정
        delivery.setDeliveryCompany(generateCourierName()); // 택배사 이름 설정
        delivery.setOrder(order); // 주문 정보 연결
        return deliveryRepository.save(delivery);
    }

    // 매일 14시에 "주문 완료" 상태를 "배송 중"으로 업데이트
    @Scheduled(cron = "0 0 14 * * ?")
    public void updateDeliveryStatus() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        for (Delivery delivery : deliveries) {
            Order order = delivery.getOrder();

            if (order.getOrderStatus() == OrderStatus.ORDERED) {
                order.setOrderStatus(OrderStatus.PREPARING); // "배송 중"으로 변경
            }
        }
    }
}

