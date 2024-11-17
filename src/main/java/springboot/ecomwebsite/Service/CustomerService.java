package springboot.ecomwebsite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.ecomwebsite.Model.Admin;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public Customer customerSignup(Customer customer) {
        return repo.save(customer);
    }

    public Customer customerLogin(String email, String password) {
        // find user by username
        Customer customer = repo.findByCustUsername(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }

    public Admin adminSignup(Admin admin) {
        //save method
        return repo.save(admin);
    }

    public Admin adminLogin(String email, String password) {
        Admin admin= repo.findByAdminUsername(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }


}
