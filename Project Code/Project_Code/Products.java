import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products {
    public static Map<String, Integer> stock = new HashMap<>();
    
    public static void checkStock() {
        System.out.println("Current stock:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void changeThings(Scanner scanner) {
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
                    addProduct(scanner);
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
    
    public static void addProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        stock.put(productName, quantity);
        System.out.println("Product added successfully.");
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