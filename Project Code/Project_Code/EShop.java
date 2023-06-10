import java.util.*;

public class EShop{
    public static void editEshop(Scanner scanner, Scanner scanner2,ArrayList<Products> products){
          while (true) {
            System.out.println("----- E-Shop Administration -----");
            System.out.println("1. Check stock");
            System.out.println("2. Change products");
            System.out.println("3. Change prices");
            System.out.println("4. Confirm and exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    Products.checkStock(products);
                    break;
                case 2:
                    Products.changeThings(scanner, scanner2, products);
                    break;
                case 3:
                    Products.openPricingPage(scanner,products);
                    break;
                case 4:
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