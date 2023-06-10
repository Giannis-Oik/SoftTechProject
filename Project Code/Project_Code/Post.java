import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Post extends Forum{
    public static ArrayList<String> userPostList2 = new ArrayList<String>();
    public static void makePost(Scanner scanner,User_profile u, ArrayList<User_profile> UserList, List<String> userPostList) {
        System.out.println("----- Post Creation -----");
        System.out.println("Write your post below:");
        System.out.println("-------------------------");
        //String post = writePost(scanner);
        String post = scanner.nextLine();
        // implementation for opening a text editor 
        if (checkPost(post)) {
            System.out.println("Warning: Your post contains inappropriate language.");
            return;
        }
        else if(!checkPost(post)){
            System.out.println(post);
            userPostList2.add(post);
            for(String word: userPostList2)
            {
                System.out.println(word);
            }
            u.setUserPostList(userPostList2);
            System.out.println("Post created successfully.");
        }
    }
    
    private static String writePost(Scanner scanner) {
        System.out.print("Enter your post: ");
        return scanner.nextLine();
    }
    
    private static boolean checkPost(String post) {
        List<String> inappropriateWords = new ArrayList<>();
        inappropriateWords.add("xontros");
        inappropriateWords.add("kontos");
        for (String word : inappropriateWords) {
            Pattern pattern = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(post);
            if (matcher.find()) {
                return true;
            }
        }
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


