import java.util.Scanner;
import java.util.ArrayList;

public class Calorie_Counter
{
    static void CounterStartUp(ArrayList<Food> FoodList, ArrayList<Drink> DrinksList, ArrayList<Exercise> ExerciseList)
    {
        System.out.println("You entered the calorie counter function.");
        System.out.println("Please select the configuration of your choice by its corresponding number:");
        System.out.print("1)Use counter to measure both burnt and consumed calories.\n2)Use only the consumed calories counter.\n3)Use only the burnt calories counter.\n");
        
        Scanner inp = new Scanner(System.in);
        
        int select = inp.nextInt();
        
        while(select < 1 || select > 3)
        {
            System.out.println("Your choice was invalid. Please make another one using the numbers 1 to 3 that corresponds to a configuration.");
            select = inp.nextInt();
        }
        
        switch(select)
        {
            case 1:
               System.out.println("You selected to use both.");
               ConsumptionCalc(FoodList, DrinksList);
               BurntCalc(ExerciseList);
               break;
            case 2:
               System.out.println("You selected to use consumed counter only.");
               ConsumptionCalc(FoodList, DrinksList);
               break;
            case 3:
               System.out.println("You selected to use burnt counter only.");
               BurntCalc(ExerciseList);
               break;
        }
        
        return;
    }
    
    static void ConsumptionCalc(ArrayList<Food> FoodList, ArrayList<Drink> DrinksList)
    {
        Consume_Count.Count_Start(FoodList, DrinksList);
        
        return;
    }
    
    static void BurntCalc(ArrayList<Exercise> ExerciseList)
    {
        Burnt_Count.Count_Start(ExerciseList);
        
        return;
    }
}