package project.demo.order_detail;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.demo.product.ProductEntity;
import project.demo.order.OrderEntity;

@Entity
@Getter
@Setter

public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_detail_id;

    private int product_quantity;
    private int order_price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
