package springboot.ecomwebsite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/signup")
    public ResponseEntity<?> customerSignup(@RequestBody Customer customer) {
        try {
            Customer newCustomer = service.customerSignup(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> customerSignin(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = service.customerLogin(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("You have successfully signed in");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials");
    }
}
