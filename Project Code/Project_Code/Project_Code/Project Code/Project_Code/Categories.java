import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Categories {
    
    public static List<String> categories = new ArrayList<>();
    
    public static void sortInCategories(Scanner scanner) {
        
        for (String category : categories) {
            System.out.print("Enter products for category '" + category + "': ");
            String products = scanner.nextLine();
        }
        System.out.println("Products sorted in categories.");
    }
}
