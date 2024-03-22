package iuh.spring.product.controller;

import iuh.spring.product.entity.Product;
import iuh.spring.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public String getHello() {
		return "Product nha";
	}

	@GetMapping("/product/all")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Thêm product
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	// Tìm product bởi ID
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	// Xóa product bởi ID
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	// Cập nhật product
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(product);
	}
}
