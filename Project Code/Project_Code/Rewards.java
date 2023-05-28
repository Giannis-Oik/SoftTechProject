import java.util.*;
import java.util.Scanner;
public class Rewards
{
    private static int points;
    private static int miniWorkoutPoints;
    private static int programPoints;
    private static int caloriePoints;
    private static int categoryDiscount;
    private static String category;
    
    public static void Rewards()
    {
        Mini_Workout.showMiniWorkout();
        Scanner input2=new Scanner(System.in);
        System.out.println("Did you complete the daily mini workout? ");
        String yesno=input2.nextLine();
        if(yesno.equals("yes"))
        {
            addMiniWorkoutPoints();
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
            addProgramPoints();
        }
        else if(yesno.equals("no"))
        {
            deduceProgramPoints();
        }
        Scanner input3=new Scanner(System.in);
        System.out.println("Did you consume within 200 calories more or less than your diet says so? ");
        String yesno3=input3.nextLine();
        if(yesno3.equals("yes"))
        {
            System.out.println("Congratulations for keeping up with your diet! ");
            addCaloriePoints();
        }
        else if(yesno3.equals("no"))
        {
            deduceCaloriePoints();
        }
        updateCategory();
        categoryDiscount();
        return ;
    }
    public static void addMiniWorkoutPoints()
    {
        miniWorkoutPoints=miniWorkoutPoints+5;
    }
    public static void addProgramPoints()
    {
         programPoints=programPoints+15;
    }
    public static void deduceProgramPoints()
    {
        programPoints=programPoints-10;
    }
    public static void addCaloriePoints()
    {
        caloriePoints=caloriePoints+10;
    }
    public static void deduceCaloriePoints()
    {
        caloriePoints=caloriePoints-10;
    }
    public static void updateCategory()
    {
        points=miniWorkoutPoints+programPoints+caloriePoints;
        System.out.println("Your total points are: "+points);
        if(points>=600)
        {
            category="Gold";
        }
        else if((points>=200) && (points<600))
        {
            category="Silver";
        }
        else if((points>=0) && (points<200))
        {
            category="Bronze";
        }
        System.out.println("Your category is: "+category);
    }
    public static void categoryDiscount()
    {
        if(category.equals("Gold"))
        {
            categoryDiscount=25;//25%
        }
        else if(category.equals("Silver"))
        {
            categoryDiscount=15;//15%
        }
        else if(category.equals("Bronze"))
        {
            categoryDiscount=0;
        }
        System.out.println("According to your category, you have a discount on the shop "+categoryDiscount+ "%");
    }
}