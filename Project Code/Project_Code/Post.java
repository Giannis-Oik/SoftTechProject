


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Post extends Forum{
    
    
    public static void makePost(Scanner scanner) {
        String post = writePost(scanner);
        System.out.println("----- Post Creation -----");
        System.out.println("Write your post below:");
        System.out.println("-------------------------");
        // implementation for opening a text editor 
        if (checkPost(post)) {
            System.out.println("Warning: Your post contains inappropriate language.");
        }

        // Save the post to the user's posts
        List<String> userPostList = userPosts.getOrDefault(currentUser, new ArrayList<>());
        userPostList.add(post);
        userPosts.put(currentUser, userPostList);

        System.out.println("Post created successfully.");
    }
    
    private static String writePost(Scanner scanner) {
        System.out.print("Enter your post: ");
        return scanner.nextLine();
    }
    
    private static boolean checkPost(String post) {
        // logic to check for inappropriate language in the post
        // and return true if any inappropriate language is found, false otherwise
        return false;
    }
    
    private static void confirm(String post) {
        System.out.println("Your post: ");
        System.out.println(post);
        System.out.print("Do you want to confirm your post? (Y/N): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (!choice.equalsIgnoreCase("Y")) {
            System.out.println("Post creation canceled.");
            System.exit(0);
        }
    }
}


