package springboot.ecomwebsite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @PostMapping
    public Customer customerSignup(@RequestBody Customer customer){
        System.out.println("You have successfully signed up!");
        return service.customerSignup(customer);

    }

    @GetMapping
    public Customer customerSignin(@RequestBody Customer customer){
        System.out.println("You have successfully signed in!");
        return service.customerSignup(customer);
    }

}
