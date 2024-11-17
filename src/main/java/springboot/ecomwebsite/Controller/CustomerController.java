package springboot.ecomwebsite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/signup")
    public Customer customerSignup(@RequestBody Customer customer) {
        return service.customerSignup(customer);
    }

    @PostMapping("/signin")
    public String customerSignin(@RequestParam String username, @RequestParam String password) {
        Customer customer = service.customerLogin(username, password);
        if (customer != null) {
            return "You have successfully signed in!";
        }
        return "Invalid username or password.";
    }
}
