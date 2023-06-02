import java.util.Scanner;
import java.util.ArrayList;

public class Consume_Count
{
    private int total_calories;
    
    public Consume_Count()
    {
        total_calories = 0;
    }
    
    static void Count_Start(ArrayList<Food> FoodList, ArrayList<Drink> DrinksList) //Methodos poy ekkhnei thn metrhsh katanalwshs
    {
        Consume_Count count = new Consume_Count();
        
        System.out.println("Consumption counter has initiated. Below you can see the list of different foods and drinks.");
     
        showFoodAndDrinksList(FoodList, DrinksList);
        
        int cont = 0;
        boolean found = false;
        
        while(cont == 0) //Gia oso o xrhsths epilegei na vazei items sto synolo (An cont = 0 synexizei alliws me 1 bgazei to synolo kai epistrefei sthn calorie counter)
        {
            System.out.println("Please select one of them to add to the total calories count(By its name only).");
        
            Scanner input = new Scanner(System.in);
        
            String item = input.nextLine();
            
            found = searchFoodAndDrinks(FoodList, DrinksList, item, count);
            
            if(found)
            {
                System.out.println("Your selection was found and its calories were added to the total.");
            }else{System.out.println("Your selection was not found.");}

            System.out.println("Do you wish to select another item or proceed and see the total calories?(Answer with y to select another or n to proceed)");
            
            item = input.nextLine();
            
            if((item.equalsIgnoreCase("no")) || (item.equalsIgnoreCase("n")))
            {
                cont = 1;
                System.out.println("You selected to proceed.");
                ShowTotal(count);
            }else{System.out.println("You will now be prompted to select another item.");}
        }
        
        return;
    }
    
    static void showFoodAndDrinksList(ArrayList<Food> FoodList, ArrayList<Drink> DrinksList) //Methodos poy diatrexei tis listes faghtwn kai potwn kai ta emfanizei
    {
        for(int i = 0; i < FoodList.size(); i++)
        {
            Food f = FoodList.get(i);
            System.out.println(f.getName());
        }
        
        for(int i = 0; i < DrinksList.size(); i++)
        {
            Drink d = DrinksList.get(i);
            System.out.println(d.getName());
        }
             
        return;
    }
        
    static boolean searchFoodAndDrinks(ArrayList<Food> FoodList, ArrayList<Drink> DrinksList, String item, Consume_Count count)//Methodos poy pairnei thn eisodo toy xrhsth kai thn anazhta
    {
        Food f;
        Drink d;
               
        for(int i = 0; i < FoodList.size(); i++)
        {
            f = FoodList.get(i);
                
            if(item.equalsIgnoreCase(f.getName())) //An vrei thn eisodo th prosthetei sto synoliko arithmo thermidwn kai proxwraei.
            {
                count.total_calories += f.getCalories();
                return true;
            }
                
        }
           
        for(int i = 0; i < DrinksList.size(); i++)
        {
            d = DrinksList.get(i);
                
            if(item.equalsIgnoreCase(d.getName()))
            {
                count.total_calories += d.getCalories();
                return true;
            }
        }
        
        return false;
    }
    
    static void ShowTotal(Consume_Count count) //Methodos poy emfanizei ton synoliko arithmo thermidwn
    {
        System.out.println("Your total consumed calories are: " + count.total_calories);
        
        return;
    }
}