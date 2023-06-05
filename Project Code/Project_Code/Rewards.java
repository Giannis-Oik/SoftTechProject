import java.util.*;
import java.util.Scanner;
public class Rewards
{
    private int categoryDiscount;
    public int totalPoints;
    private String category;
    
    public Rewards()
    {
        this.categoryDiscount = 0;
        this.totalPoints = 0;
        this.category = "";
    }
    
    public static void DailyRewards(ArrayList<Exercise> ExerciseList, User_profile u)
    {
        Rewards rewards = new Rewards();
        Mini_Workout.showMiniWorkout(ExerciseList);
        Scanner input2=new Scanner(System.in);
        System.out.println("Did you complete the daily mini workout? ");
        String yesno=input2.nextLine();
        if(yesno.equals("yes"))
        {
            rewards.addMiniWorkoutPoints();
        }
        else if(yesno.equals("no"))
        {
            System.out.println("Next time complete it to gain points! ");
        }
        //showPersonalWorkout();
        System.out.println("Did you complete your personal workout? ");
        String yesno2=input2.nextLine();
        if(yesno.equals("yes"))
        {
            rewards.addProgramPoints();
        }
        else if(yesno.equals("no"))
        {
            rewards.deduceProgramPoints();
        }
        Scanner input3=new Scanner(System.in);
        System.out.println("Did you consume within 200 calories more or less than your diet says so? ");
        String yesno3=input3.nextLine();
        if(yesno3.equals("yes"))
        {
            System.out.println("Congratulations for keeping up with your diet! ");
            rewards.addCaloriePoints();
        }
        else if(yesno3.equals("no"))
        {
            rewards.deduceCaloriePoints();
        }
        //updateCategory(User_ProfileList);
        rewards.categoryDiscount(u);
        return ;
    }
    public static void updateCategory(ArrayList<User_profile> User_ProfileList,User_profile u)
    {
        //points=miniWorkoutPoints+programPoints+caloriePoints;
        System.out.println("Your total points are: "+u.getProfilePoints());
        if(u.getProfilePoints()>=600)
        {
            u.category="Gold";
        }
        else if((u.getProfilePoints()>=200) && (u.getProfilePoints()<600))
        {
            u.category="Silver";
        }
        else if((u.getProfilePoints()>=0) && (u.getProfilePoints()<200))
        {
            u.category="Bronze";
        }
        System.out.println("Your category is: "+u.category);
    }
    public static void categoryDiscount(User_profile u)
    {
        String cat=u.getProfileCategory();
        if(cat.equals("Gold"))
        {
            u.setProfileDiscount(25);//25%
        }
        else if(cat.equals("Silver"))
        {
            u.setProfileDiscount(15);//15%
        }
        else if(cat.equals("Bronze"))
        {
            u.setProfileDiscount(0);
        }
        System.out.println("According to your category, you have a discount on the shop "+u.getProfileDiscount() + "%");
    }
    public void addMiniWorkoutPoints()
    {
        this.totalPoints+=5;
    }
    public void addProgramPoints()
    {
         this.totalPoints+=15;
    }
    public void deduceProgramPoints()
    {
        this.totalPoints-=10;
    }
    public void addCaloriePoints()
    {
        this.totalPoints+=10;
    }
    public void deduceCaloriePoints()
    {
        this.totalPoints-=10;
    }
    public void TotalPoints(User_profile u)
    {
        u.setProfilePoints(totalPoints);
    }
}