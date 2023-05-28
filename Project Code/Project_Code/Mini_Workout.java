import java.util.*;
import java.util.Scanner;

public class Mini_Workout
{
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
}