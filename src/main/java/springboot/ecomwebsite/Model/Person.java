package springboot.ecomwebsite.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;

    Person(String name,String username, String email, String phone, String password){
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
protected abstract void login(String username, String Password) ;
protected abstract void signup(String username, String Password);
protected abstract void viewProducts(Product product);
}
