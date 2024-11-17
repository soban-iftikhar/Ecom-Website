package springboot.ecomwebsite.Model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Order  {
    private Customer customer; // Customer who placed the order
    private List<Product> products; // Products included in the order
    private LocalDateTime orderDate; // Date when the order was placed
    private String status; // Status of the order (e.g., Pending, Completed)

    // Constructor
    public Order(int id, String name, Customer customer, List<Product> products, LocalDateTime orderDate, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.customer = customer;
        this.products = products;
        this.orderDate = orderDate;
        this.status = status;
    }
}
