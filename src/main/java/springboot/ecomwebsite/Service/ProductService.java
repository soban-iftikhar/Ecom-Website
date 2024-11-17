package springboot.ecomwebsite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.ecomwebsite.Model.Product;
import springboot.ecomwebsite.Repo.ProductRepo;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    // Function to get all products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
    // Function to get  product by id
    public Product getProductById(int id) {
        return repo.findById(id).orElseThrow();
    }

    // Function to add product
    public Product addProduct(Product product) {
        return repo.save(product);
    }


    public Product updateProduct(int id, Product productDetails) {
        Product existingProduct = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setIsAvailable(productDetails.getIsAvailable());
        return repo.save(existingProduct);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
