package project.demo.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //상품 목록 조회
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    //상품 추가
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }
}
