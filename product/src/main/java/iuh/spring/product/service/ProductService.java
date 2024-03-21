package iuh.spring.product.service;import iuh.spring.product.entity.Product;import iuh.spring.product.repositories.ProductRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.cache.annotation.CacheEvict;import org.springframework.cache.annotation.Cacheable;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;@Servicepublic class ProductService {    @Autowired    private  ProductRepository productRepository;    public ProductService(ProductRepository productRepository) {        this.productRepository = productRepository;    }    @Cacheable("products")    public List<Product> getAllProduct() {        return productRepository.findAll();    }    @Cacheable(value = "product", key = "#id")    public Optional<Product> getProductById(long id) {        return productRepository.findById(id);    }    public Product creProduct(Product product) {        return productRepository.save(product);    }    @CacheEvict(value = "product", key = "#id")    public Product updateProduct(long id, Product product) {        product.setId(id);        return productRepository.save(product);    }    @CacheEvict(value = "product", key = "#id")    public void deleteProduct(long id) {        productRepository.deleteById(id);    }}