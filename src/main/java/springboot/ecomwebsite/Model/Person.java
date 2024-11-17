package springboot.ecomwebsite.Model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public abstract class Person {

    private String name;
//    private String username;
    private String email;
    private String phone;
    private String password;

protected abstract void login(String username, String Password) ;
protected abstract void signup(String username, String Password);
protected abstract void viewProducts(Product product);
}
