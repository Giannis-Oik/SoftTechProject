public class Meal
{
    private String name;
    private Food food;
    private Food secondary;
    private Food third;
    private Drink drink;
    private String type;
    private int calories_total;
    
    public Meal(String n, Food f,Food f2, Drink d, String t)
    {
        name = n;
        food = f;
        secondary = f2;
        drink = d;
        type = t;
        calories_total = f.getCalories() + d.getCalories();
    }
    
    public Meal(String n, Food f, Food sec, Food th, Drink d, String t)
    {
        name = n;
        food = f;
        secondary = sec;
        third = th;
        drink = d;
        type = t;
        calories_total = f.getCalories() + secondary.getCalories() + third.getCalories() + d.getCalories();
    }
    
    public Meal(String n, Food f,Drink d)
    {
        name = n;
        food = f;
        drink = d;
        type = "Evening meal";
        calories_total = f.getCalories() + d.getCalories();
    }
    
    public int getCalories()
    {
        return calories_total;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getType()
    {
        return type;
    }
}