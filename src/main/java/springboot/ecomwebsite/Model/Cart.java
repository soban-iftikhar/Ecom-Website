package springboot.ecomwebsite.Model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Cart  {
    private String name;
    private Customer customer;
    private List<Product> products;

    // Constructor
    public Cart(int id, String name, Customer customer, List<Product> products, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.customer = customer;
        this.products = products;
    }
}
