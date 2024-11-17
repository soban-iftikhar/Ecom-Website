package springboot.ecomwebsite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.ecomwebsite.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
//    @Query("SELECT c FROM Customer c WHERE LOWER(c.username) = LOWER(:username)")
    Customer findByUsername(@Param("username") String username);
}
