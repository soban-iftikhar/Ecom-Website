package springboot.ecomwebsite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.ecomwebsite.Model.Admin;
import springboot.ecomwebsite.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository <Customer, Long>{

    Customer findByCustUsername(String username);
    Admin findByAdminUsername(String username);
}
