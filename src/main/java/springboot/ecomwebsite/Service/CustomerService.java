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
        if (repo.findByUsername(customer.getUsername()) != null || repo.findByEmail(customer.getEmail()) != null) {
            throw new IllegalArgumentException("Username or Email already exists");
        }
        return repo.save(customer);
    }

    public boolean customerLogin(String username, String password) {
        Customer customer = repo.findByUsername(username);
        return customer != null &&
                (customer.getEmail().equals(username) || customer.getUsername().equals(username)) &&
                customer.getPassword().equals(password);
    }
}
