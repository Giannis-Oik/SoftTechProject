import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Messages extends Forum{
    
    
    public static void openMessages(Scanner scanner) {
        System.out.println("----- Messages -----");
        System.out.println("1. Show messages");
        System.out.println("2. Go back");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        switch (choice) {
            case 1:
                showMessages(scanner);
                break;
            case 2:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private static void showMessages(Scanner scanner) {
        List<String> userMessageList = userMessages.getOrDefault(currentUser, new ArrayList<>());

        if (userMessageList.isEmpty()) {
            System.out.println("You have no messages.");
            return;
        }

        System.out.println("----- Your Messages -----");
        for (int i = 0; i < userMessageList.size(); i++) {
            System.out.println((i + 1) + ". " + userMessageList.get(i));
        }

        System.out.print("Select a message to respond (enter the number): ");
        int messageIndex = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        if (messageIndex > 0 && messageIndex <= userMessageList.size()) {
            String selectedMessage = userMessageList.get(messageIndex - 1);
            System.out.println("You selected message: " + selectedMessage);

            // Open text editor for response
            System.out.println("----- Message Response -----");
            System.out.println("Write your response below:");
            System.out.println("-----------------------------");
            String response = scanner.nextLine();

            // Send response (save it to the original sender's messages)
            String sender = selectedMessage.split(":")[0];
            List<String> senderMessageList = userMessages.getOrDefault(sender, new ArrayList<>());
            senderMessageList.add(currentUser + ": " + response);
            userMessages.put(sender, senderMessageList);

            System.out.println("Response sent successfully.");
        } else {
            System.out.println("Invalid message selection.");
        }
    }
}