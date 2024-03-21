package iuh.spring.product.controller;

import iuh.spring.product.entity.Product;
import iuh.spring.product.repositories.ProductRepository;
import iuh.spring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;
	@GetMapping("/test")
	public String getProduct() {
		return "Product nhe";
	}
	@PostMapping()
	public Product saveProduct(@RequestBody Product product){
		productService.creProduct(product);
				return product;
	}
	@GetMapping("/all")
	public List<Product> getAllProduct(){
		List<Product> products = productService.getAllProduct();
		System.out.println(products);
		return products;
	}
}
