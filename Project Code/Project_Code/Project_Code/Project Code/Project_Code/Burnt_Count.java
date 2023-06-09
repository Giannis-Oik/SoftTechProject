import java.util.Scanner;
import java.util.ArrayList;

public class Burnt_Count
{
    private int total_calories;
    
    public Burnt_Count()
    {
        total_calories = 0;
    }
    
    static void Count_Start(ArrayList<Exercise> ExerciseList) //Methodos poy ekkhnei thn metrhsh kayshs
    {
        Burnt_Count count = new Burnt_Count();
        
        System.out.println("Burnt calories counter has initiated. Below you can see the list of different exercises to choose from.");
        
        ShowExerciseList(ExerciseList);
        
        int proceed = 0;
        boolean found = false;
        
        while(proceed == 0) //Gia oso o xrhsths epilegei na vazei items sto synolo (An cont = 0 synexizei alliws me 1 bgazei to synolo kai epistrefei sthn calorie counter)
        {
            System.out.println("Please select one exercise to add its calories burnt per set to the total count(By its name only).");
        
            Scanner input = new Scanner(System.in);
        
            String item = input.nextLine();
            
            found = SearchExercise(ExerciseList, count, item);
            
            if(found)
            {
                System.out.println("Your selection was found and its calories were added to the total.");
            }else{System.out.println("Your selection was not found.");}
            
            System.out.println("Do you wish to select another item or proceed and see the total calories burnt?(Answer with y to select another or n to proceed)");
            
            item = input.nextLine();
            
            if((item.equalsIgnoreCase("no")) || (item.equalsIgnoreCase("n")))
            {
                proceed = 1;
                System.out.println("You selected to proceed.");
                System.out.println("The total burnt calories of the selected exercises is: " + count.total_calories);
            }else{System.out.println("You will now be prompted to select another item.");}
        }
        
        return;
    }
    
    static void ShowExerciseList(ArrayList<Exercise> ExerciseList) //Methodos poy emfanizei tis askhseis gia tis opoies yparxoyn katagegrammenes times
    {
        for(int i = 0; i < ExerciseList.size(); i++)
        {
            Exercise e = ExerciseList.get(i);
            
            System.out.println(e.getExerName());
        }
        
        return;
    }
    
    static boolean SearchExercise(ArrayList<Exercise> ExerciseList,Burnt_Count count, String item) //Methodos poy ektelei thn anazitish ths eisodoy sth lista askhsewn
    {
        Exercise e;
        
        for(int i = 0; i < ExerciseList.size(); i++) 
        {
            e = ExerciseList.get(i);
                
            if(item.equalsIgnoreCase(e.getExerName())) //An vrei thn eisodo th prosthetei sto synoliko arithmo thermidwn
            {
                count.total_calories += e.getCalBurnt();
                return true;
            }
        }
        
        return false;
    }
    
    static void ShowTotal(Burnt_Count count) //Methodos poy emfanizei to synolo kammenwn thermidwn
    {
        System.out.println("The total burnt calories of the selected exercises is: " + count.total_calories);
        
        return;
    }
}