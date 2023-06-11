import java.util.ArrayList;
import java.util.List;

public class Feed extends Forum{
    public static void gotoFeed(User_profile u,ArrayList<User_profile> UserList,List<String> userConnectionsList,List<String> userPostList) {
       System.out.println("----- Feed -----");
       for (int i = 0; i < u.getUserConnectionsList().size(); i++) {
           
           User_profile follower = UserList.get(i);
           
                for (int j = 0; j < follower.getUserPostList().size(); j++) {
                System.out.println(follower.getProfileName() + ": " + follower.getUserPostList().get(j));
             }
           
         }
       }
    }

