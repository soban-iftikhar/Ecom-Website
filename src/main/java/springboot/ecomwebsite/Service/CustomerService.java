package springboot.ecomwebsite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public Customer customerSignup(Customer customer) {
        if (repo.findByUsername(customer.getUsername()) != null) {
            System.out.println("Username already existed");
            return null;
        }
        return repo.save(customer);
    }

    public Customer customerLogin(String username, String password) {
        Customer customer = repo.findByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}
