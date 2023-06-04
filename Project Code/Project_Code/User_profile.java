import java.util.*;

public class User_profile
{
    private ArrayList<Exercise> ExMonday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExTuesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExWednesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExThursday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExFriday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExSaturday = new ArrayList<Exercise>();
    
    private ArrayList<Meal> FoodMonday = new ArrayList<Meal>();
    private ArrayList<Meal> FoodTuesday = new ArrayList<Meal>();
    private ArrayList<Meal> FoodWednesday = new ArrayList<Meal>();
    private ArrayList<Meal> FoodThursday = new ArrayList<Meal>();
    private ArrayList<Meal> FoodFriday = new ArrayList<Meal>();
    private ArrayList<Meal> FoodSaturday = new ArrayList<Meal>();
    

    
    public User_profile()
    {
    }
    
    public boolean CheckIfPlanExists()
    {
        if((ExMonday.isEmpty()) && (ExTuesday.isEmpty()) && (ExWednesday.isEmpty()) && (ExThursday.isEmpty()) && (ExFriday.isEmpty()) && (ExSaturday.isEmpty()))
        {
            return false;
        }else {return true;}
    }
    
    public void DeletePlan()
    {
        ExMonday.clear(); ExTuesday.clear(); ExWednesday.clear(); ExThursday.clear(); ExFriday.clear(); ExSaturday.clear();
        FoodMonday.clear(); FoodTuesday.clear(); FoodWednesday.clear(); FoodThursday.clear(); FoodFriday.clear(); FoodSaturday.clear();
    }
    
    //Get and set methods:
    
    public ArrayList getExMonday()
    {
        return ExMonday;
    }
    
    public void setExMonday(ArrayList<Exercise> list)
    {
        ExMonday.clear();
        ExMonday.addAll(list);
        
        return;
    }
    
    public ArrayList getExTuesday()
    {
        return ExTuesday;
    }
    
    public void setExTuesday(ArrayList<Exercise> list)
    {
        ExTuesday.clear();
        ExTuesday.addAll(list);
        
        return;
    }
    
    public ArrayList getExWednesday()
    {
        return ExWednesday;
    }
    
    public void setExWednesday(ArrayList<Exercise> list)
    {
        ExWednesday.clear();
        ExWednesday.addAll(list);
        
        return;
    }
    
    public ArrayList getExThursday()
    {
        return ExThursday;
    }
    
    public void setExThursday(ArrayList<Exercise> list)
    {
        ExThursday.clear();
        ExThursday.addAll(list);
        
        return;
    }
    
    public ArrayList getExFriday()
    {
        return ExFriday;
    }
    
    public void setExFriday(ArrayList<Exercise> list)
    {
        ExFriday.clear();
        ExFriday.addAll(list);
        
        return;
    }
    
    public ArrayList getExSaturday()
    {
        return ExSaturday;
    }
    
    public void setExSaturday(ArrayList<Exercise> list)
    {
        ExSaturday.clear();
        ExSaturday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodMonday()
    {
        return FoodMonday;
    }
    
    public void setFoodMonday(ArrayList<Meal> list)
    {
        FoodMonday.clear();
        FoodMonday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodTuesday()
    {
        return FoodTuesday;
    }
    
    public void setFoodTuesday(ArrayList<Meal> list)
    {
        FoodTuesday.clear();
        FoodTuesday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodWednesday()
    {
        return FoodWednesday;
    }
    
    public void setFoodWednesday(ArrayList<Meal> list)
    {
        FoodWednesday.clear();
        FoodWednesday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodThursday()
    {
        return FoodThursday;
    }
    
    public void setFoodThursday(ArrayList<Meal> list)
    {
        FoodThursday.clear();
        FoodThursday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodFriday()
    {
        return FoodFriday;
    }
    
    public void setFoodFriday(ArrayList<Meal> list)
    {
        FoodFriday.clear();
        FoodFriday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodSaturday()
    {
        return FoodSaturday;
    }
    
    public void setFoodSaturday(ArrayList<Meal> list)
    {
        FoodSaturday.clear();
        FoodSaturday.addAll(list);
        
        return;
    }
}
