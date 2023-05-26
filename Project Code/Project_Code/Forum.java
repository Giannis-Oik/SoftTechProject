import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Forum {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public static Map<String, String> users = new HashMap<>();
    public static Map<String, List<String>> userPosts = new HashMap<>();
    public static Map<String, List<String>> userMessages = new HashMap<>();
    public static Map<String, List<String>> userConnections = new HashMap<>();

    public static String currentUser;

    public static void forum() {
        Scanner scanner = new Scanner(System.in);

        // Add some example users 
        users.put("user1", "pass1");
        users.put("user2", "pass2");
        users.put("user3", "pass3");

        // Login
        login(scanner);

        // Forum menu
        while (true) {
            System.out.println("----- Fitness Forum -----");
            System.out.println("1. Make a post");
            System.out.println("2. Open messages");
            System.out.println("3. View profiles");
            System.out.println("4. Browse feed");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    Post.makePost(scanner);
                    break;
                case 2:
                    Messages.openMessages(scanner);
                    break;
                case 3:
                    Profile_Page.showProfilePage(scanner);
                    break;
                case 4:
                    gotoFeed();
                    break;
                case 5:
                    System.out.println("Exiting the forum. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("User logged in successfully.");
            currentUser = username;
        } else {
            System.out.println("Invalid credentials. Exiting the forum.");
            System.exit(0);
        }
    }

    

    
    private static void gotoFeed() {
        List<String> currentUserConnectionsList = userConnections.getOrDefault(currentUser, new ArrayList<>());

        System.out.println("----- Feed -----");
        for (String user : currentUserConnectionsList) {
            List<String> userPostList = userPosts.getOrDefault(user, new ArrayList<>());
            for (String post : userPostList) {
                System.out.println(user + ": " + post);
            }
        }
    }
}
