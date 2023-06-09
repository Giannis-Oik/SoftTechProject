import java.util.*;
public class Mini_Workout
{
    static void showMiniWorkout(ArrayList<Exercise> ExerciseList)
    {
        Collections.shuffle(ExerciseList);
        Exercise e;
        Date d=new Date();
        int day=d.getDay();
        if(day==1)
        {
            System.out.println("Today is Monday.This is the daily mini workout: ");
            e=ExerciseList.get(0);
            System.out.println(e.getExerName());
        }
        else if(day==2)
        {
            System.out.println("Today is Tuesday.This is the daily mini workout: ");
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(1);
            System.out.println(e.getExerName());
        }
        else if(day==3)
        {
            System.out.println("Today is Wednesday.This is the daily mini workout: ");
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(2);
            System.out.println(e.getExerName());
        }
        else if(day==4)
        {
            System.out.println("Today is Thursday.This is the daily mini workout: ");
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(3);
            System.out.println(e.getExerName());
        }
        else if(day==5)
        {
            System.out.println("Today is Friday.This is the daily mini workout: ");
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(4);
            System.out.println(e.getExerName());
        }
        else if(day==6)
        {
            System.out.println("Today is Saturday.This is the daily mini workout: ");
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(5);
            System.out.println(e.getExerName());
        }
        else if(day==7)
        {
            System.out.println("Today is Sunday.This is the daily mini workout: ");
            Collections.shuffle(ExerciseList);
            e=ExerciseList.get(6);
            System.out.println(e.getExerName());
        }
    }
}