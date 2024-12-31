package project.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 해당 클래스를 entity로 설정
public class Product {
    @Id // 해당 필드가 테이블의 기본 키(primary key) 임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키 값을 데이터베이스에서 자동으로 생성
    private Long productId;

    private String productName;
    private int productPrice;
    private String productDescription;
    private int productStock;

}
