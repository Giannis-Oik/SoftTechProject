public class Exercise
{
    private String ExerciseName, MusclesAffected, Variation;
    private int AvgCaloriesBurnt;
    
    public Exercise(String name, String muscles, String var, int calories)
    {
        ExerciseName = name;
        MusclesAffected = muscles;
        Variation = var;
        AvgCaloriesBurnt = calories;
    }
    
    public String getExerName()
    {
        return ExerciseName;
    }
    
    public String getMuscles()
    {
        return MusclesAffected;
    }
    
    public String getVariation()
    {
        return Variation;
    }
    
    public int getCalBurnt()
    {
        return AvgCaloriesBurnt;
    }
}