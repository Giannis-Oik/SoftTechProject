import java.util.*;

public class Messages extends Forum{
    public static void openMessages(Scanner scanner,User_profile u, ArrayList<User_profile> UserList, List<String> userMessageList) {
        System.out.println("----- Messages -----");
        System.out.println("1. Show messages");
        System.out.println("2. Send a message");
        System.out.println("3. Go back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        switch (choice) {
            case 1:
                showMessages(scanner,u,userMessageList,UserList);
                break;
            case 2:
                sendMessages(scanner,u,UserList);
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private static void sendMessages(Scanner scanner, User_profile u, ArrayList<User_profile> UserList){
        System.out.println("Select the user you want to send a message to (enter the number):");
        //UserList.remove(u);

        System.out.println("----- User List -----");
        
        for (int i = 0; i < UserList.size(); i++) {
            UserList.remove(u);
            User_profile otherusers = UserList.get(i);
            System.out.println((i + 1) + ". "  + otherusers.getProfileName());
        }
        
        int userIndex = scanner.nextInt();
        scanner.nextLine(); 
        if (userIndex > 0 && userIndex <= UserList.size()) {
            User_profile receiver = UserList.get(userIndex - 1);
            // Open text editor for response
            System.out.println("----- Send Message -----");
            System.out.println("Write your message below:");
            System.out.println("-----------------------------");
            String message = scanner.nextLine();
            String senderName = u.getProfileName();
            String messageWithSender = senderName + ":" + message;
            u.getUserMessageList().add(message);
            receiver.getUserMessageList().add(messageWithSender);
            System.out.println("Message sent successfully!");
        }
    }
    
    private static void showMessages(Scanner scanner,User_profile u,List<String> userMessageList,ArrayList<User_profile> UserList) {
        if (u.getUserMessageList().isEmpty()) {
            System.out.println("You have no messages.");
            return;
        }

        System.out.println("----- Your Messages -----");
        for (int i = 0; i < u.getUserMessageList().size(); i++) {
            System.out.println((i + 1) + ". " + u.getUserMessageList().get(i));
        }
        
        sendMessages(scanner,u,UserList);
        /*System.out.print("Select a message to respond (enter the number): ");
        int messageIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        if (messageIndex > 0 && messageIndex <= u.getUserMessageList().size()) {
            String selectedMessage = u.getUserMessageList().get(messageIndex - 1);
            System.out.println("You selected message: " + selectedMessage);

            // Open text editor for response
            System.out.println("----- Message Response -----");
            System.out.println("Write your response below:");
            System.out.println("-----------------------------");
            String response = scanner.nextLine();

            // Send response (save it to the original sender's messages)
            String sender = selectedMessage.split(":")[0];
            
            u.getUserMessageList().add(u.getProfileName() + ": " + response);
            

            System.out.println("Response sent successfully.");
        } else {
            System.out.println("Invalid message selection.");
        }*/
    }
}