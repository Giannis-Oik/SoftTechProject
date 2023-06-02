public class Food
{
    private String foodname;
    private int foodcalories, foodprotein, foodsodium, foodpot, foodchol, foodcarbs;
    private double foodfat;
    
    public Food(String name,int cal,int protein,int sodium,int pot,int chol,int carbs,double fat)
    {
        foodname = name;
        foodcalories = cal;
        foodprotein = protein;
        foodsodium = sodium;
        foodpot = pot;
        foodchol = chol;
        foodcarbs = carbs;
        foodfat = fat;
    }
    
    public int getCalories()
    {
        return foodcalories;
    }
    
    public int getProtein()
    {
        return foodprotein;
    }
    
    public int getSodium()
    {
        return foodsodium;
    }
    
    public int getPotassium()
    {
        return foodpot;
    }
    
    public int getCholesterol()
    {
        return foodchol;
    }
    
    public int getCarbs()
    {
        return foodcarbs;
    }
    
    public double getFat()
    {
        return foodfat;
    }
    
    public String getName()
    {
        return foodname;
    }
}