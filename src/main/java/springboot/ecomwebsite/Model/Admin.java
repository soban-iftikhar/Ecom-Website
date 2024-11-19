//package springboot.ecomwebsite.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDate;
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity
//public class Admin extends Person{
//
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private String username;
//    private LocalDate joinedAt;
//
//
//    public Admin(int id, String name, String username, String email, String phone, String password, LocalDate joinedAt) {
//        super(name,email,phone,password);
//        this.joinedAt = joinedAt;
//
//    }
//
//    @Override
//    protected void login(String username, String Password) {
//
//    }
//
//    @Override
//    protected void signup(String username, String Password) {
//
//    }
//
//    @Override
//    protected void viewProducts(Product product) {
//
//    }
//}
