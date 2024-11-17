package springboot.ecomwebsite.Model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    private String description;
    private double price;
    private String category;
    private Boolean isAvailable;
    private boolean isDeleted;

    // Default constructor
    public Product() {
    }

    //parameterized constructor
    public Product(String name, String description, double price, String category, Boolean isAvailable) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public Boolean getAvailable() {
//        return isAvailable;
//    }
//

}