package project.demo.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.demo.product.ProductEntity;
import project.demo.product.ProductRepository;

import java.util.List;

@Controller
public class OrderController {

    private final ProductRepository productRepository;

    public OrderController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        List<ProductEntity> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "order";
    }
}
