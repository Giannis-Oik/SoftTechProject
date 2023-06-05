import java.util.*;

public class Mini_Workout
{
    static void showMiniWorkout(ArrayList<Exercise> ExerciseList)
    {
        Collections.shuffle(ExerciseList);
        Exercise e;
        System.out.println("What day is it? ");
        Scanner input1=new Scanner(System.in);
        String day=input1.nextLine();
        System.out.print("This is the daily mini workout: " );
        if(day.equals("Monday"))
        {
            e=ExerciseList.get(0);
            System.out.println(e.getExerName());
        }
        else if(day.equals("Tuesday"))
        {
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(1);
            System.out.println(e.getExerName());
        }
        else if(day.equals("Wednesday"))
        {
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(2);
            System.out.println(e.getExerName());
        }
        else if(day.equals("Thursday"))
        {
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(3);
            System.out.println(e.getExerName());
        }
        else if(day.equals("Friday"))
        {
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(4);
            System.out.println(e.getExerName());
        }
        else if(day.equals("Saturday"))
        {
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(5);
            System.out.println(e.getExerName());
        }
        else if(day.equals("Sunday"))
        {
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(6);
            System.out.println(e.getExerName());
        }
    }
}