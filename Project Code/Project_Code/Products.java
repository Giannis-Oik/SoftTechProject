import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Products {
    public static Map<String, Integer> stock = new HashMap<>();
    private String name;
    private double price;
    private String category;
    private int quantity;
    public Products(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    
    public String getCategory() {
        return category;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public static void checkStock() {
       System.out.println("Current stock:");
       for (int i = 0; i < Shop.products.size(); i++) {
         Products product = Shop.products.get(i);
         System.out.println("ID: " + (i + 1));
         System.out.println("Name: " + product.getName());
         System.out.println("Price: " + product.getPrice());
         System.out.println("Quantity: " + product.getQuantity());
         System.out.println();
       }
    }
    
    public static void changeThings(Scanner scanner, Scanner scanner2) {
        while (true) {
           
            System.out.println("----- Change Products -----");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Update product");
            System.out.println("4. Go back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addProduct(scanner, scanner2);
                    break;
                case 2:
                    deleteProduct(scanner);
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    public static void addProduct(Scanner scanner, Scanner scanner2) {
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the product category (Supplements, Clothes, Shoes, Accessories, Gear) : ");
        String category = scanner2.nextLine();
        System.out.print("Enter the product's quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < Shop.products.size(); i++) {
           Products product = Shop.products.get(i);
           if(name == product.getName()){
               quantity = quantity + product.getQuantity();
               Shop.products.add(new Products(name,price,category,quantity));
           }
           else{
               Shop.products.add(new Products(name,price,category,quantity));
           }
       }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        if (stock.containsKey(productName)) {
            stock.remove(productName);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found in stock.");
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        if (stock.containsKey(productName)) {
            System.out.print("Enter the new quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); 

            stock.put(productName, quantity);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found in stock.");
        }
    }
    
    public static void openPricingPage(Scanner scanner) {
    
       System.out.println("Current products and prices:");
       for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
       }

       System.out.print("Do you want to make changes? (Y/N): ");
       String choice = scanner.nextLine();

       if (choice.equalsIgnoreCase("Y")) {
            makeChanges(scanner);
       }
    }

    public static void makeChanges(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        if (stock.containsKey(productName)) {
            System.out.print("Enter the new price: ");
            int price = scanner.nextInt();
            scanner.nextLine(); 

            stock.put(productName, price);
            System.out.println("Price changed successfully.");
        } else {
            System.out.println("Product not found in stock.");
        }
    }
}