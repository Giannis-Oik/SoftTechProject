public class Exercise
{
    private String ExerciseName, MusclesAffected, Variation, MainType;
    private int AvgCaloriesBurnt;
    
    public Exercise(String name, String muscles, String var, int calories, String type)
    {
        ExerciseName = name;
        MusclesAffected = muscles;
        Variation = var;
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
    
    public String getVariation()
    {
        return Variation;
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