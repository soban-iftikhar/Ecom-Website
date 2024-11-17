package springboot.ecomwebsite.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity


public class Customer extends Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String username;
    private int id;
    private LocalDate birthday;


    // Constructor
    public Customer(int id, String name,String username, String email, String phone, String password, LocalDate birthday) {
        super(name,email,phone,password);
        this.id = id;
        this.birthday = birthday;

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
