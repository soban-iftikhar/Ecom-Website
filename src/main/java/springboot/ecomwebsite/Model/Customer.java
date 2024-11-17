package springboot.ecomwebsite.Model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Entity

public class Customer extends Person {

    private String birthday;
    private String address;


    // Constructor
    public Customer(String name,String username, String email, String phone, String password, String birthday, String address) {
        super(name,username,email,phone,password);
        this.birthday = birthday;
        this.address = address;


    }

    @Override
    protected void login(String username, String Password) {

    }

    @Override
    protected void signup(String username, String Password) {

    }

    @Override
    protected void viewProducts(Product product) {

    }
}
