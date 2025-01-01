package project.demo.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity // 해당 클래스를 entity로 설정
public class ProductEntity {
    @Id // 해당 필드가 테이블의 기본 키(primary key) 임을 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키 값을 데이터베이스에서 자동으로 생성
    private Long product_id;

    private String product_name;
    private int product_price;

    @Column(length = 500)
    private String product_description;
    private int product_stock;
    private LocalDateTime created_at;
}
