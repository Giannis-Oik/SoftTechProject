public class Exercise
{
    private String ExerciseName, MusclesAffected, MainType;
    private int AvgCaloriesBurnt;
    
    public Exercise(String name, String muscles,  int calories, String type)
    {
        ExerciseName = name;
        MusclesAffected = muscles;
        AvgCaloriesBurnt = calories;
        MainType = type;
    }
    
    public String getExerName()
    {
        return ExerciseName;
    }
    
    public String getMuscles()
    {
        return MusclesAffected;
    }
    
    public int getCalBurnt()
    {
        return AvgCaloriesBurnt;
    }
    
    public String getType()
    {
        return MainType;
    }
}