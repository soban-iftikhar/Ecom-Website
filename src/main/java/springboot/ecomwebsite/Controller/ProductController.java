package springboot.ecomwebsite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.ecomwebsite.Model.Product;
import springboot.ecomwebsite.Service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // Get a specific product by id
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }

    // Add a new product
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // Update an existing product by id
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        return service.updateProduct(id, productDetails);
    }

    // Delete a product by id
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product with id " + id + " has been deleted.";
    }
}
