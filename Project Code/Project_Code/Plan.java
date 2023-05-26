import java.util.Scanner;
import java.util.ArrayList;

public class Plan
{
    static void New_Plan(User_profile u,ArrayList<Exercise> ExerciseList)
    {
        boolean exists;
        exists = u.CheckIfPlanExists();
        //Vasei toy email check gia to an o xrhsths exei plano hdh
        
        if(exists) 
        {
           //Yparxei programma
           System.out.println("A plan already exists. Do you wish to make a new one?(Answer with y or n)");
           
           Scanner input = new Scanner(System.in);
           String nc = input.nextLine();
           
           if(nc != "y" && nc != "Y" && nc != "YES" && nc != "yes") 
           {
               System.out.println("You selected to not make a new plan and you will now return to the home screen.");
               return;
           }else
           {
               System.out.println("You selected to make a new plan.");
               //Profile.DeletePlan(email); diagrafi yparxwn planoy
               Exercise_Plan.Make_ExPlan(u,ExerciseList);
               Food_Plan.Make_FoodPlan();
           }
        }else
        {
           //Den yparxei programma 
           Exercise_Plan.Make_ExPlan(u, ExerciseList);
           Food_Plan.Make_FoodPlan();
        }
        
        return;
    }
}