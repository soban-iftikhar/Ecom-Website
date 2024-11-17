package springboot.ecomwebsite.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.ecomwebsite.Model.Product;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
