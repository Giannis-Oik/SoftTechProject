public class Drink
{
    private String drinkname;
    private int drinkcalories, drinkprotein, drinksodium, drinkpot, drinkchol, drinkcarbs;
    private float drinkfat;
    
    public Drink(String name,int cal,int protein,int sodium,int pot,int chol,int carbs,float fat)
    {
        drinkname = name;
        drinkcalories = cal;
        drinkprotein = protein;
        drinksodium = sodium;
        drinkpot = pot;
        drinkchol = chol;
        drinkcarbs = carbs;
        drinkfat = fat;
    }
    
    public int getCalories()
    {
        return drinkcalories;
    }
    
    public int getProtein()
    {
        return drinkprotein;
    }
    
    public int getSodium()
    {
        return drinksodium;
    }
    
    public int getPotassium()
    {
        return drinkpot;
    }
    
    public int getCholesterol()
    {
        return drinkchol;
    }
    
    public int getCarbs()
    {
        return drinkcarbs;
    }
    
    public float getFat()
    {
        return drinkfat;
    }
    
    public String getName()
    {
        return drinkname;
    }
}