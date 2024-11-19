package springboot.ecomwebsite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.ecomwebsite.Model.Customer;
import springboot.ecomwebsite.Model.Product;
import springboot.ecomwebsite.Service.CustomerService;
import springboot.ecomwebsite.Service.ProductService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EcomWebsite implements CommandLineRunner {

    @Autowired
    private ProductService service;
    @Autowired
    private CustomerService cService;

    public static void main(String[] args) {
        SpringApplication.run(EcomWebsite.class, args); // Start the Spring Boot application
    }

    @Override
    public void run(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loggedIn = false;
        String userRole = "";

        while (true) {
            if (!loggedIn) {
                System.out.println("\nWelcome to the E-Commerce System");
                System.out.println("1. Admin Login");
                System.out.println("2. Customer Login");
                System.out.println("3. Customer Signup");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Admin Login (Placeholder, you can implement actual login logic)
                        System.out.print("Enter Admin Username: ");
                        String adminUsername = input.nextLine();
                        System.out.print("Enter Admin Password: ");
                        String adminPassword = input.nextLine();

                        // Placeholder check (add real validation here)
                        if ("admin".equals(adminUsername) && "admin123".equals(adminPassword)) {
                            loggedIn = true;
                            userRole = "Admin";
                            System.out.println("Admin Login successful.");
                        } else {
                            System.out.println("Admin Login failed.");
                        }
                        break;

                    case 2:
                        // Customer Login
                        System.out.print("Enter Customer Username or Email: ");
                        String username = input.nextLine();
                        System.out.print("Enter Customer Password: ");
                        String password = input.nextLine();

                        boolean isAuthenticated = cService.customerLogin(username, password);
                        if (isAuthenticated) {
                            loggedIn = true;
                            userRole = "Customer";
                            System.out.println("Login successful! Welcome back, " + username);
                        } else {
                            System.out.println("Login failed: Incorrect username or password.");
                        }
                        break;

                    case 3:
                        // Customer Signup
                        System.out.println("Enter Your Name");
                        String name = input.nextLine();
                        System.out.println("Enter username");
                        String signupUsername = input.nextLine();
                        System.out.println("Enter Your Email");
                        String email = input.nextLine();
                        System.out.println("Enter password");
                        String signupPassword = input.nextLine();
                        System.out.println("Enter phone#");
                        String phone = input.nextLine();
                        System.out.println("Enter Your DOB (YYYY-MM-DD)");
                        String dob = input.nextLine();
                        System.out.println("Enter Address");
                        String address = input.nextLine();

                        // Create Customer object
                        Customer customer = new Customer(name, signupUsername, email, phone, signupPassword, dob, address);
                        try {
                            cService.customerSignup(customer);
                            System.out.println("Signup successful! Welcome, " + customer.getUsername());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Signup failed: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                // Nested menu based on role (Admin or Customer)
                if ("Admin".equals(userRole)) {
                    // Admin-specific menu
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. View Products");
                    System.out.println("2. Add Product");
                    System.out.println("3. Update Product");
                    System.out.println("4. Delete Product");
                    System.out.println("5. Logout");

                    System.out.print("Enter your choice: ");
                    int adminChoice = input.nextInt();
                    input.nextLine(); // Consume newline

                    switch (adminChoice) {
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

                        case 3:
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

                        case 4:
                            System.out.print("Enter Product ID to delete: ");
                            int deleteID = input.nextInt();
                            service.deleteProduct(deleteID);
                            System.out.println("Product deleted successfully.");
                            break;

                        case 5:
                            loggedIn = false;
                            System.out.println("Logged out successfully.");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                } else if ("Customer".equals(userRole)) {
                    // Customer-specific menu
                    System.out.println("\nCustomer Menu:");
                    System.out.println("1. View Products");
                    System.out.println("2. View Product Details");
                    System.out.println("3. Logout");

                    System.out.print("Enter your choice: ");
                    int customerChoice = input.nextInt();
                    input.nextLine(); // Consume newline

                    switch (customerChoice) {
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
                            input.nextLine(); // Consume newline
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
                            loggedIn = false;
                            System.out.println("Logged out successfully.");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
    }
}
