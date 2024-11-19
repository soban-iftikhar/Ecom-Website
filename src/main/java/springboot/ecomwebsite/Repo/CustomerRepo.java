package springboot.ecomwebsite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.ecomwebsite.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);
}
