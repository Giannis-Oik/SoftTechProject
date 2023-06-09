import java.util.Scanner;
import java.util.ArrayList;

public class Plan
{
    static void New_Plan(User_profile u,ArrayList<Exercise> ExerciseList,ArrayList<Meal> MealList)
    {
        boolean exists;
        exists = u.CheckIfPlanExists();
        //Check gia to an o xrhsths exei plano hdh. An exei to exists einai true alliws false.
        
        if(exists) 
        {
           //Yparxei programma
           System.out.println("A plan already exists. Do you wish to make a new one?(Answer with y or n)");
           
           Scanner input = new Scanner(System.in);
           String nc = input.nextLine();
           
           if((nc.equalsIgnoreCase("n")) || (nc.equalsIgnoreCase("no")))
           {
               System.out.println("You selected to not make a new plan and you will now return to the home screen.");
               return;
           }else
           {
               System.out.println("You selected to make a new plan.");
               u.DeletePlan(); //Diagrafi yparxwn planoy
               Exercise_Plan.Make_ExPlan(u,ExerciseList);
               Food_Plan.Make_FoodPlan(u,MealList);
           }
        }else
        {
           //Den yparxei programma 
           Exercise_Plan.Make_ExPlan(u, ExerciseList);
           Food_Plan.Make_FoodPlan(u,MealList);
        }
        
        return;
    }
}