import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User
{
    //private static Map<String, String> users= new HashMap<>();
    public static void login()
    {
        System.out.println("Welcome to Fitness App! \n");
        Scanner input1=new Scanner(System.in);
        System.out.print("Do you have a profile? ");
        String yesno=input1.nextLine();
        if(yesno.equals("yes"))
        {
            System.out.print("Give your name to log in: ");
            String Name=input1.nextLine();
            System.out.print("Password: ");
            String Password=input1.nextLine();
            if (checkProfile(Name, Password)) {
                System.out.println("Login successful!");
                return ;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
            //showUserProfile();
        }
        else if(yesno.equals("no"))
        {
            System.out.print("You will get asked for some features to create your profile.");
            UserProfile.createProfile();
        }
        //System.out.println("You logged in successfully!");
    }
    private static boolean checkProfile(String Name, String Password) {
      return UserProfile.getProfileName().equals(Name) && UserProfile.getProfilePassword().equals(Password);
    }
    
    /*public static void profile()
    {
        users = new HashMap<>();
        users.put("Nikos", "nikos1");  // Example user: admin, password: password123
        users.put("Stamatis", "stam2");
    }
    */
    
    /*public static void showProfile()
    {
        System.out.print(newUser);
    }*/
}