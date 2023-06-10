import java.util.*;

public class Profile_Page extends Forum{
    public static ArrayList<String> userConnectionsList2 = new ArrayList<String>();
    public static void showProfilePage(Scanner scanner,User_profile u,ArrayList<User_profile> UserList,List<String> userConnectionsList ) {
        System.out.println("----- Profile Page -----");
        System.out.println("1. Open user list");
        System.out.println("2. Go back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                openList(u,UserList,userConnectionsList);
                break;
            case 2:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private static void openList(User_profile u,ArrayList<User_profile> UserList, List<String> userConnectionsList ) {
         

        // Get the list of users that the current user doesn't follow
        
         UserList.removeAll(u.getUserConnectionsList());
         UserList.remove(u);

        System.out.println("----- User List -----");
        
        for (int i = 0; i < UserList.size(); i++) {
            User_profile otherusers = UserList.get(i);
            System.out.println((i + 1) + ". "  + otherusers.getProfileName());
        }

        System.out.print("Select a user to follow (enter the number): ");
        Scanner scanner = new Scanner(System.in);
        int userIndex = scanner.nextInt();
        scanner.nextLine(); 

        if (userIndex > 0 && userIndex <= UserList.size()) {
            User_profile selectedUser = UserList.get(userIndex - 1);
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Would you like to see this user's profile (Y/N) ");
            String choice = scanner2.nextLine();
            if(choice.equalsIgnoreCase("Y")){
                selectedUser.ShowProfile();
                
            }
            else if(choice.equalsIgnoreCase("N")){
                System.out.println("OK continue");
            }
            System.out.println("Proceed to follow? (Y/N) ");
            String choice2 = scanner2.nextLine();
            if(choice2.equalsIgnoreCase("Y")){
                System.out.println("You followed user: " + selectedUser.getProfileName());
                userConnectionsList2.add(selectedUser.getProfileName());
                u.setUserConnectionsList(userConnectionsList2);

                System.out.println("Connection added successfully.");
            }
            else if(choice2.equalsIgnoreCase("N")){
                System.out.println("Returning to menu:");
                return;
            }

            // Add the connection (follow) between the users
            
        } else {
            System.out.println("Invalid user selection.");
        }
    }
}