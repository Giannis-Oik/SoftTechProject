import java.util.*;

public class Forum {
 
    public static void forum(User_profile u,ArrayList<User_profile> UserList,List<String> userMessageList,List<String> userConnectionsList,List<String> userPostList) {
        Scanner scanner = new Scanner(System.in);

        

        // Forum menu
        while (true) {
            System.out.println("----- Fitness Forum -----");
            System.out.println("1. Make a post");
            System.out.println("2. Open or send messages");
            System.out.println("3. View profiles");
            System.out.println("4. Browse feed");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    Post.makePost(scanner,u,UserList,userPostList);
                    break;
                case 2:
                    Messages.openMessages(scanner,u,UserList,userMessageList);
                    break;
                case 3:
                    Profile_Page.showProfilePage(scanner,u,UserList,userConnectionsList);
                    break;
                case 4:
                    Feed.gotoFeed(u,UserList, userConnectionsList,userPostList);
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
}
