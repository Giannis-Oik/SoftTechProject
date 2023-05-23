import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EShopAdministration {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private static Map<String, Integer> stock = new HashMap<>();
    private static List<String> categories = new ArrayList<>();

    public static void checkadmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!isAdmin(username, password)) {
            System.out.println("Access denied. Only admin can access this functionality.");
            return;
        }

        editEshop(scanner);
    }

    private static boolean isAdmin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private static void editEshop(Scanner scanner) {
        while (true) {
            System.out.println("----- E-Shop Administration -----");
            System.out.println("1. Check stock");
            System.out.println("2. Change products");
            System.out.println("3. Sort products in categories");
            System.out.println("4. Change prices");
            System.out.println("5. Confirm and exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    checkStock();
                    break;
                case 2:
                    changeThings(scanner);
                    break;
                case 3:
                    sortInCategories(scanner);
                    break;
                case 4:
                    openPricingPage(scanner);
                    break;
                case 5:
                    confirmChanges(scanner);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void checkStock() {
        System.out.println("Current stock:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void changeThings(Scanner scanner) {
        while (true) {
            System.out.println("----- Change Products -----");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Update product");
            System.out.println("4. Go back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

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

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        stock.put(productName, quantity);
        System.out.println("Product added successfully.");
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        if (stock.containsKey(productName)) {
            stock.remove(productName);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found in stock.");
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        if (stock.containsKey(productName)) {
            System.out.print("Enter the new quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            stock.put(productName, quantity);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found in stock.");
        }
    }

    private static void sortInCategories(Scanner scanner) {
        // Assuming the categories list is pre-populated
        for (String category : categories) {
            System.out.print("Enter products for category '" + category + "': ");
            String products = scanner.nextLine();
            // Store the products in their respective categories
            // You can use a data structure like a Map<String, List<String>> to store the products in categories
        }
        System.out.println("Products sorted in categories.");
    }

    private static void openPricingPage(Scanner scanner) {
        // Display the current products and their prices
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

    private static void makeChanges(Scanner scanner) {
        System.out.print("Enter the product name: ");
        String productName = scanner.nextLine();

        if (stock.containsKey(productName)) {
            System.out.print("Enter the new price: ");
            int price = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            stock.put(productName, price);
            System.out.println("Price changed successfully.");
        } else {
            System.out.println("Product not found in stock.");
        }
    }

    private static void confirmChanges(Scanner scanner) {
        System.out.print("Are you sure you want to confirm the changes? (Y/N): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Changes confirmed. Exiting e-shop administration.");
        } else {
            System.out.println("Returning to e-shop administration.");
        }
    }
}