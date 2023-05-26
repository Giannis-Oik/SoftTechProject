import java.util.*;

public class User_profile
{
    private ArrayList<Exercise> ExMonday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExTuesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExWednesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExThursday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExFriday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExSaturday = new ArrayList<Exercise>();

    
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
}
