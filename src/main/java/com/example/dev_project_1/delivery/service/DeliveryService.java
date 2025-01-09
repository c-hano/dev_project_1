package com.example.dev_project_1.delivery.service;

import com.example.dev_project_1.delivery.model.Delivery;
import com.example.dev_project_1.delivery.repository.DeliveryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Scheduled(cron = "0 0 14 * * ?")
    //14시에 배송 상품들 일괄처리
    public void updateDeliveryStatus() {
        var deliveries = deliveryRepository.findAll();
        deliveries.forEach(delivery -> {
            if (delivery.getStatus() == Delivery.DeliveryStatus.PREPARING) {
                delivery.setStatus(Delivery.DeliveryStatus.SHIPPING);
                deliveryRepository.save(delivery);
            }
        });
    }
    // 배송 ID로 해당 상품 배송 정보 조회
    public Delivery findById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid delivery ID: " + deliveryId));
    }

    public String generateRandomTrackingNumber() {
        Random random = new Random();
        StringBuilder trackingNumber = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            trackingNumber.append(random.nextInt(10)); // 0~9 사이의 숫자 추가
        }
        return trackingNumber.toString();
    }

    // 랜덤한 두 글자의 한글을 생성하는 메서드
    public String generateRandomKoreanName() {
        Random random = new Random();
        char firstChar = (char) (random.nextInt(11172) + 44032); // 유니코드 한글 범위: 0xAC00 ~ 0xD7A3
        char secondChar = (char) (random.nextInt(11172) + 44032); // 두 번째 글자
        return "" + firstChar + secondChar + "택배"; // 랜덤 두 글자 + "택배"
    }

    // 배송 객체 생성 및 저장
    public Delivery saveDelivery(Delivery delivery) {
        delivery.setDeliveryNumber(generateRandomTrackingNumber()); // 랜덤 운송장 번호 설정
        delivery.setDeliveryCompany(generateRandomKoreanName()); // 랜덤 배송 회사 이름 설정
        return deliveryRepository.save(delivery);
    }
}

