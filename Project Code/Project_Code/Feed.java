import java.util.ArrayList;
import java.util.List;

public class Feed extends Forum{
    
    public static void gotoFeed() {
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
