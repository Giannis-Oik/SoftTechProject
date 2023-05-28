import java.util.*;
public class Rewards
{
    private static int points;
    private static int miniWorkoutPoints;
    private static int programPoints;
    private static int caloriePoints;
    private static int categoryDiscount;
    private static String category;
    
    @Override
    public String toString() {
        return "\n MiniWorkout{" +
                "Name='" + Exercise.ExerciseName + '\'' +
                ", Muscles='" + Exercise.MusclesAffected + '\'' +
                ", Variation='" + Exercise.Variation + '\'' +
                ", Calories='" + Exercise.AvgCaloriesBurnt + 
                '}';
    }
    public static void showMiniWorkout()
    {
        List <Exercise> listOfMiniWorkouts=new ArrayList<>();
        Exercise exercise1=new Exercise("pushups","chest","3x12",100);
        Exercise exercise2=new Exercise("situps","abs","3x15",100);
        Exercise exercise3=new Exercise("burpees","cardio","3x20",100);
        Exercise exercise4=new Exercise("run","cardio","1.5 km",100);
        Exercise exercise5=new Exercise("rope","cardio","200 du",100);
        Exercise exercise6=new Exercise("squats","quads/glutes","3x15",100);
        Exercise exercise7=new Exercise("plank","core","3x1 minute",100);
        listOfMiniWorkouts.add(exercise1);
        listOfMiniWorkouts.add(exercise2);
        listOfMiniWorkouts.add(exercise3);
        listOfMiniWorkouts.add(exercise4);
        listOfMiniWorkouts.add(exercise5);
        listOfMiniWorkouts.add(exercise6);
        listOfMiniWorkouts.add(exercise7);
        System.out.println("What day is it? ");
        Scanner input1=new Scanner(System.in);
        String day=input1.nextLine();
        System.out.print("This is the daily mini workout: " );
        if(day.equals("Monday"))
        {
            System.out.println(exercise1);
        }
        else if(day.equals("Tuesday"))
        {
            System.out.println(exercise2);
        }
        else if(day.equals("Wednesday"))
        {
            System.out.println(exercise3);
        }
        else if(day.equals("Thursday"))
        {
            System.out.println(exercise4);
        }
        else if(day.equals("Friday"))
        {
            System.out.println(exercise5);
        }
        else if(day.equals("Saturday"))
        {
            System.out.println(exercise6);
        }
        else if(day.equals("Sunday"))
        {
            System.out.println(exercise7);
        }
    }
    public static void Rewards()
    {
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