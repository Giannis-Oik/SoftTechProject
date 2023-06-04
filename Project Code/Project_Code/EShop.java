import java.util.Scanner;

public class EShop{
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    public static void checkadmin() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!isAdmin(username, password)) {
            System.out.println("Access denied. Only admin can access this functionality.");
            return;
        }

        editEshop(scanner,scanner2);
    }

    private static boolean isAdmin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    private static void editEshop(Scanner scanner, Scanner scanner2){
        Shop shop = new Shop();
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
                    Products.checkStock();
                    break;
                case 2:
                    Products.changeThings(scanner, scanner2);
                    break;
                case 3:
                    Categories.sortInCategories(scanner);
                    break;
                case 4:
                    Products.openPricingPage(scanner);
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