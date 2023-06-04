import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Profile_Page extends Forum{
    public static void showProfilePage(Scanner scanner) {
        System.out.println("----- Profile Page -----");
        System.out.println("1. Open user list");
        System.out.println("2. Go back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                openList();
                break;
            case 2:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private static void openList() {
        List<String> userConnectionsList = userConnections.getOrDefault(currentUser, new ArrayList<>());

        // Get the list of users that the current user doesn't follow
        List<String> userList = new ArrayList<>(users.keySet());
        userList.removeAll(userConnectionsList);
        userList.remove(currentUser);

        System.out.println("----- User List -----");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println((i + 1) + ". " + userList.get(i));
        }

        System.out.print("Select a user to follow (enter the number): ");
        Scanner scanner = new Scanner(System.in);
        int userIndex = scanner.nextInt();
        scanner.nextLine(); 

        if (userIndex > 0 && userIndex <= userList.size()) {
            String selectedUser = userList.get(userIndex - 1);
            System.out.println("You followed user: " + selectedUser);

            // Add the connection (follow) between the users
            List<String> currentUserConnectionsList = userConnections.getOrDefault(currentUser, new ArrayList<>());
            currentUserConnectionsList.add(selectedUser);
            userConnections.put(currentUser, currentUserConnectionsList);

            System.out.println("Connection added successfully.");
        } else {
            System.out.println("Invalid user selection.");
        }
    }
}