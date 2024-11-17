package springboot.ecomwebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Model.Product;
import springboot.ecomwebsite.Service.CustomerService;
import springboot.ecomwebsite.Service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EcomWebsite implements CommandLineRunner {

    @Autowired
    private ProductService service;
    @Autowired
    private CustomerService cService;
//    private AdminService aService;

    public static void main(String[] args) {
        SpringApplication.run(EcomWebsite.class, args); // Start the Spring Boot application
    }

    @Override
    public void run(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the E-Commerce System");
            System.out.println("1. View Products");
            System.out.println("2. View Product Details");
            System.out.println("3. Add Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
//            System.out.println("Admin login");
            System.out.println("6. Customer login");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Product> products = service.getAllProducts();
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("Available Products:");
                        for (Product product : products) {
                            System.out.println(product.getId() + ": " + product.getName());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int productID = input.nextInt();
                    Product product = service.getProductById(productID);
                    if (product != null) {
                        System.out.println("Product Details: ");
                        System.out.println("ID: " + product.getId());
                        System.out.println("Name: " + product.getName());
                        System.out.println("Description: " + product.getDescription());
                        System.out.println("Price: " + product.getPrice());
                        System.out.println("Category: " + product.getCategory());
                        System.out.println("Available: " + product.getIsAvailable());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter Product details: ");
                    System.out.print("Enter Product Name: ");
                    String productName = input.nextLine();
                    System.out.print("Enter Product Description: ");
                    String productDescription = input.nextLine();
                    System.out.print("Enter Product Price: ");
                    double productPrice = input.nextDouble();
                    input.nextLine(); // Consume newline
                    System.out.print("Enter Product Category: ");
                    String productCategory = input.nextLine();

                    // Create new Product object and add it to the service
                    Product newProduct = new Product(productName, productDescription, productPrice, productCategory, true);
                    service.addProduct(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 4:
                    System.out.print("Enter Product ID to update: ");
                    int updateID = input.nextInt();
                    input.nextLine(); // Consume newline
                    Product existingProduct = service.getProductById(updateID);
                    if (existingProduct != null) {
                        System.out.print("Enter new name: ");
                        existingProduct.setName(input.nextLine());
                        System.out.print("Enter new description: ");
                        existingProduct.setDescription(input.nextLine());
                        System.out.print("Enter new price: ");
                        existingProduct.setPrice(input.nextDouble());
                        input.nextLine(); // Consume newline
                        System.out.print("Enter new category: ");
                        existingProduct.setCategory(input.nextLine());
                        service.updateProduct(updateID, existingProduct);
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteID = input.nextInt();
                    service.deleteProduct(deleteID);
                    System.out.println("Product deleted successfully.");
                    break;

                case 6:
                    System.out.println("Enter Your Name");
                    String name = input.nextLine();
                    System.out.println("Enter username");
                    String username = input.nextLine();
                    System.out.println("Enter Your Email");
                    String email = input.nextLine();
                    System.out.println("Enter password");
                    String password = input.nextLine();
                    System.out.println("Enter phone#");
                    String phone = input.nextLine();
                    System.out.println("Enter Your DOB (YYYY-MM-DD)");
                    String dob = input.nextLine();
                    System.out.println("Enter Address");
                    String address = input.nextLine();

                    // Create Customer object
                    Customer customer = new Customer(name, username, email, phone, password, dob, address);

                    // Sign up the customer
                    cService.customerSignup(customer);
                    break;

                case 0:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


//
//package springboot.ecomwebsite;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//public class EcomWebsite {
//    public static void main(String[] args) {
//        SpringApplication.run(EcomWebsite.class, args);
//    }
//}