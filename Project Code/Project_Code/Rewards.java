import java.util.*;
import java.util.Scanner;
public class Rewards
{
    private int categoryDiscount;
    public int totalPoints=0;
    private String category;
    private int miniWorkoutPoints=0;
    private int programPoints=0;
    private int caloriePoints=0;
    public Rewards()
    {
        this.categoryDiscount = 0;
        this.totalPoints = 0;
        this.category = "";
    }
    
    public static void DailyRewards(ArrayList<Exercise> ExerciseList, User_profile u)
    {
        Rewards rewards = new Rewards();
        rewards.totalPoints=u.getProfilePoints();
        Mini_Workout.showMiniWorkout(ExerciseList);
        Scanner input2=new Scanner(System.in);
        System.out.println("Did you complete the daily mini workout? ");
        String yesno=input2.nextLine();
        if(yesno.equalsIgnoreCase("yes") || yesno.equalsIgnoreCase("y"))
        {
            rewards.addMiniWorkoutPoints();
        }
        else
        {
            System.out.println("Next time complete it to gain points! ");
        }
        System.out.println("Did you complete your personal workout? ");
        String yesno2=input2.nextLine();
        if(yesno.equalsIgnoreCase("yes") || yesno.equalsIgnoreCase("y"))
        {
            rewards.addProgramPoints();
        }
        else
        {
            rewards.deduceProgramPoints();
        }
        Scanner input3=new Scanner(System.in);
        System.out.println("Did you consume within 200 calories more or less than your diet says so? ");
        String yesno3=input3.nextLine();
        if(yesno.equalsIgnoreCase("yes") || yesno.equalsIgnoreCase("y"))
        {
            System.out.println("Congratulations for keeping up with your diet! ");
            rewards.addCaloriePoints();
        }
        else
        {
            rewards.deduceCaloriePoints();
        }
        rewards.TotalPoints(u);
        rewards.updateCategory(u);
        rewards.categoryDiscount(u);
        return ;
    }
    public static void updateCategory(User_profile u)
    {
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
        String newcat=u.category;
        u.setProfileCategory(newcat);
        System.out.println("Your category is: "+newcat);
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
        System.out.println("According to your category, you have a discount on the shop: "+u.getProfileDiscount() + "%");
    }
    public void addMiniWorkoutPoints()
    {
        miniWorkoutPoints=5;
    }
    public void addProgramPoints()
    {
         programPoints=15;
    }
    public void deduceProgramPoints()
    {
        programPoints=-10;
    }
    public void addCaloriePoints()
    {
        caloriePoints=10;
    }
    public void deduceCaloriePoints()
    {
        caloriePoints=-10;
    }
    public void TotalPoints(User_profile u)
    {
        int profPoints=u.getProfilePoints()+miniWorkoutPoints+programPoints+caloriePoints;
        u.setProfilePoints(profPoints);
        System.out.println("Your total points are: "+u.getProfilePoints());
    }
}