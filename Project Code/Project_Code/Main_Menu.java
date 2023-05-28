import java.util.Scanner;
import java.util.ArrayList;

public class Main_Menu 
{
    static ArrayList<Food> FoodList = new ArrayList<Food>();
    static ArrayList<Drink> DrinksList = new ArrayList<Drink>();
    static ArrayList<Exercise> ExerciseList = new ArrayList<Exercise>();
    static ArrayList<Meal> MealList = new ArrayList<Meal>();
    public static void Main_Menu()
    {
        int count = 1;
        User_profile u = new User_profile();
        while(count == 1)
        {
            System.out.println("Main menu:");
System.out.print("1)Make plan of diet and exercise\n2)Calorie counter\n3)E-Shop\n4)Check your profile\n5)Daily awards\n6)Eshop(admin only)\n7)Forum\n8)Exit\n");
        
            Scanner input = new Scanner(System.in);
        
            System.out.println("Select one of the apps functions by the corresponding number only.");
        
            int choice = input.nextInt();
        
            while(choice > 8 || choice < 1)
            {
                System.out.println("Your choice was invalid. Please make another one using the numbers 1 to 8 that correspond to the functions.");
                choice = input.nextInt();
            }
        
            switch(choice)
            {
                case 1:
                    System.out.println("Make plan of diet and exercise.");
                    Plan.New_Plan(u,ExerciseList,MealList);
                    break;
                case 2:
                    System.out.println("Calorie counter.");
                    Calorie_Counter.CounterStartUp(FoodList, DrinksList, ExerciseList);
                    break;
                case 3:
                System.out.println("E-shop.");
                EShop_Menu.eshopStart();
                break;
                case 4:
                    System.out.println("Check your profile.");
                    break;
                case 5:
                    System.out.println("Daily awards.");
                    break;
                case 6:
                    System.out.println("Eshop(admin only).");
                    EShop.checkadmin();
                    break;
                case 7:
                    System.out.println("Forum.");
                    Forum.forum();
                    break;
                case 8:
                    System.out.println("Good-bye. Do not forget to follow your plans.");
                    count = 0;
                    break;
            }
        }
    }
}