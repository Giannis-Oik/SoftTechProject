import java.util.*;

public class Food_Plan
{
    private ArrayList<Meal> Monday = new ArrayList<Meal>();
    private ArrayList<Meal> Tuesday = new ArrayList<Meal>();
    private ArrayList<Meal> Wednesday = new ArrayList<Meal>();
    private ArrayList<Meal> Thursday = new ArrayList<Meal>();
    private ArrayList<Meal> Friday = new ArrayList<Meal>();
    private ArrayList<Meal> Saturday = new ArrayList<Meal>();
    
    private ArrayList<Exercise> ExMonday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExTuesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExWednesday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExThursday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExFriday = new ArrayList<Exercise>();
    private ArrayList<Exercise> ExSaturday = new ArrayList<Exercise>();
    
    public Food_Plan(){}
    
    static void Make_FoodPlan(User_profile u, ArrayList<Meal> MealList)
    {
        Food_Plan plan = new Food_Plan();
        
        int type = 0;
        
        System.out.println("The construction of your diet plan is underway.");
        
        plan.Find_appropriate_FoodAndDrinks(u,type,MealList);
        
        plan.Show_Plan();
        
        plan.Make_changes();
        
        plan.Save_plan(u);
    }
    
    private void Find_appropriate_FoodAndDrinks(User_profile u,int type,ArrayList<Meal> MealList)
    {
        System.out.println("Please select one of the following choices regarding your goals with the constructed plan:(use the corresponding numbers 1 to 3 for your choice)");
        System.out.println("1)Weight loss\n2)Weight gain/Muscle gain\n3)No weight change(Usually for ones who just want to start eating healthier with a plan)");
        
        Scanner input = new Scanner(System.in);
        
        type = input.nextInt();
        
        int i,totalMonday = 0, totalTuesday = 0, totalWednesday = 0, totalThursday = 0, totalFriday = 0, totalSaturday = 0; 
        
        Exercise e;
        Meal m;
        
        //Metafora planoy gymnastikhs apo to profile gia ton ypologismo kathe hmerisiwn kammenwn thermidwn
        ExMonday = u.getExMonday();
        ExTuesday = u.getExTuesday();
        ExWednesday = u.getExWednesday();
        ExThursday = u.getExThursday();
        ExFriday = u.getExFriday();
        ExSaturday= u.getExSaturday();
        
        if(!ExMonday.isEmpty()) //An kapoia mera exei programma gymnastikhs tote ypologise poses thermides kaiei o xrhsths alliws astes 0
        {
            for(i = 0; i < ExMonday.size(); i++)
            {
                e = ExMonday.get(i);
                
                totalMonday += e.getCalBurnt();
            }
        }
        
        if(!ExTuesday.isEmpty())
        {
            for(i = 0; i < ExTuesday.size(); i++)
            {
                e = ExTuesday.get(i);
                
                totalTuesday += e.getCalBurnt();
            }
        }
        
        if(!ExWednesday.isEmpty())
        {
            for(i = 0; i < ExWednesday.size(); i++)
            {
                e = ExWednesday.get(i);
                
                totalWednesday += e.getCalBurnt();
            }
        }
        
        if(!ExThursday.isEmpty())
        {
            for(i = 0; i < ExThursday.size(); i++)
            {
                e = ExThursday.get(i);
                
                totalThursday += e.getCalBurnt();
            }
        }
        
        if(!ExFriday.isEmpty())
        {
            for(i = 0; i < ExFriday.size(); i++)
            {
                e = ExFriday.get(i);
                
                totalFriday += e.getCalBurnt();
            }
        }
        
        if(!ExSaturday.isEmpty())
        {
            for(i = 0; i < ExSaturday.size(); i++)
            {
                e = ExSaturday.get(i);
                
                totalSaturday += e.getCalBurnt();
            }
        }
        
        int count = 1;
        switch(type) //Dhmiourgia programmatos vasei kai twn parapanw totals apo tis askhseis
        {
            case 1: //Weight loss programma opou oi thermides poy katanalwnei kapoios prepei na einai ligoteres apo oses kaiei
                Collections.shuffle(MealList); //Shuffle ginetai gia randomise ths listas wste kathe fora na epilegontai diaforetika geymata
                
                for(i = 0; i < MealList.size(); i++) //Anazitisi geymatos prwinou me ths katallhles thermides gia eisagwgi sthn kathe hmera.
                {
                    m = MealList.get(i);
                    
                    if((m.getType() == "Breakfast") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                    {
                        Monday.add(m); Tuesday.add(m); Wednesday.add(m); Thursday.add(m); Friday.add(m); Saturday.add(m);
                        count--;
                        break;
                    }
                }
                    
                Collections.shuffle(MealList);
                
                if(totalMonday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++) //Anazitisi geymatos meshmerianou me ths katallhles thermides gia eisagwgi sthn ekastote hmera.
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++) //Anazitisi geymatos apogeumatinou me ths katallhles thermides gia eisagwgi sthn ekastote hmera.
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++) //Anazitisi geymatos vradinou me ths katallhles thermides gia eisagwgi sthn ekastote hmera.
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                }else 
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalTuesday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalWednesday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalThursday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalFriday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalSaturday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                break;
            case 2: //Weight gain programma opou oi thermides poy katanalwnei kapoios prepei na einai perissoteres apo oses kaiei
                Collections.shuffle(MealList);
                
                for(i = 0; i < MealList.size(); i++)
                {
                    m = MealList.get(i);
                    
                    if((m.getType() == "Breakfast") && (m.getCalories()  >= 320) && (count > 0))
                    {
                        Monday.add(m); Tuesday.add(m); Wednesday.add(m); Thursday.add(m); Friday.add(m); Saturday.add(m);
                        count --;
                        break;
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalMonday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++) //Anazitisi geymatos dekatianou me ths katallhles thermides gia eisagwgi sthn ekastote hmera.
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Brunch") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                }else 
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalTuesday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Brunch") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalWednesday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Brunch") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalThursday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Brunch") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalFriday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Brunch") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalSaturday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Brunch") && (m.getCalories() <= 300) && (m.getCalories() >= 200) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 250) && (m.getCalories() >= 150)&& (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() >= 750) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                break;
            case 3: //Neutral weight programma opou oi thermides poy katanalwnei kapoios prepei na einai ises me oses kaiei
                Collections.shuffle(MealList);
                
                for(i = 0; i < MealList.size(); i++)
                {
                    m = MealList.get(i);
                    
                    if((m.getType() == "Breakfast") && (m.getCalories() <= 350) && (m.getCalories() >= 250) && (count > 0))
                    {
                        Monday.add(m); Tuesday.add(m); Wednesday.add(m); Thursday.add(m); Friday.add(m); Saturday.add(m);
                        count--;
                        break;
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalMonday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (m.getCalories() >= 100) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                }else 
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Monday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalTuesday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (m.getCalories() >= 100) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Tuesday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalWednesday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (m.getCalories() >= 100) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Wednesday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalThursday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (m.getCalories() >= 100) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Thursday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalFriday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (m.getCalories() >= 100) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Friday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                
                Collections.shuffle(MealList);
                
                if(totalSaturday > 0)
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Evening meal") && (m.getCalories() <= 200) && (m.getCalories() >= 100) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                }else
                {
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Lunch") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                    
                    count = 1;
                    for(i = 0; i < MealList.size(); i++)
                    {
                        m = MealList.get(i);
                        
                        if((m.getType() == "Dinner") && (m.getCalories() <= 800) && (m.getCalories() >= 700) && (count > 0))
                        {
                            Saturday.add(m);
                            count--;
                            break;
                        }
                    }
                }
                break;
        }
    }
    
    private void Show_Plan() //Methodos poy emfanizei to programma
    {
        Meal m;
        System.out.println("The generated diet plan is the following:");
        System.out.println("Monday: ");
        
        if(Monday.size() == 3) //An sth mera yparxei mono prwino meshmeriano vradino 
        {
            m = Monday.get(0);
            System.out.println("Breakfast: " + m.getName());
            m = Monday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Monday.get(2);
            System.out.println("Dinner: "+ m.getName());
        }else if(Monday.size() == 4) //An sth mera yparxei mono prwino meshmeriano apogeymatino kai vradino 
        {
            m = Monday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Monday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Monday.get(2);
            System.out.println("Evening meal: "+ m.getName());
            m = Monday.get(3);
            System.out.println("Dinner: "+ m.getName());
        }else if(Monday.size() == 5) //An sth mera yparxoun ola ta geymata
        {
            m = Monday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Monday.get(1);
            System.out.println("Brunch: "+ m.getName());
            m = Monday.get(2);
            System.out.println("Lunch: "+ m.getName());
            m = Monday.get(3);
            System.out.println("Evening meal: "+ m.getName());
            m = Monday.get(4);
            System.out.println("Dinner: "+ m.getName());
        }
        
        System.out.println("Tuesday: ");
        
        if(Tuesday.size() == 3)
        {
            m = Tuesday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Tuesday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Tuesday.get(2);
            System.out.println("Dinner: "+ m.getName());
        }else if(Tuesday.size() == 4)
        {
            m = Tuesday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Tuesday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Tuesday.get(2);
            System.out.println("Evening meal: "+ m.getName());
            m = Tuesday.get(3);
            System.out.println("Dinner: "+ m.getName());
        }else if(Tuesday.size() == 5)
        {
            m = Tuesday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Tuesday.get(1);
            System.out.println("Brunch: "+ m.getName());
            m = Tuesday.get(2);
            System.out.println("Lunch: "+ m.getName());
            m = Tuesday.get(3);
            System.out.println("Evening meal: "+ m.getName());
            m = Tuesday.get(4);
            System.out.println("Dinner: "+ m.getName());
        }
        
        System.out.println("Wednesday: ");
        
        if(Wednesday.size() == 3)
        {
            m = Wednesday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Wednesday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Wednesday.get(2);
            System.out.println("Dinner: "+ m.getName());
        }else if(Wednesday.size() == 4)
        {
            m = Wednesday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Wednesday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Wednesday.get(2);
            System.out.println("Evening meal: "+ m.getName());
            m = Wednesday.get(3);
            System.out.println("Dinner: "+ m.getName());
        }else if(Wednesday.size() == 5)
        {
            m = Wednesday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Wednesday.get(1);
            System.out.println("Brunch: "+ m.getName());
            m = Wednesday.get(2);
            System.out.println("Lunch: "+ m.getName());
            m = Wednesday.get(3);
            System.out.println("Evening meal: "+ m.getName());
            m = Wednesday.get(4);
            System.out.println("Dinner: "+ m.getName());
        }
        
        System.out.println("Thursday: ");
        
        if(Thursday.size() == 3)
        {
            m = Thursday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Thursday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Thursday.get(2);
            System.out.println("Dinner: "+ m.getName());
        }else if(Thursday.size() == 4)
        {
            m = Thursday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Thursday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Thursday.get(2);
            System.out.println("Evening meal: "+ m.getName());
            m = Thursday.get(3);
            System.out.println("Dinner: "+ m.getName());
        }else if(Thursday.size() == 5)
        {
            m = Thursday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Thursday.get(1);
            System.out.println("Brunch: "+ m.getName());
            m = Thursday.get(2);
            System.out.println("Lunch: "+ m.getName());
            m = Thursday.get(3);
            System.out.println("Evening meal: "+ m.getName());
            m = Thursday.get(4);
            System.out.println("Dinner: "+ m.getName());
        }
        
        System.out.println("Friday: ");
        
        if(Friday.size() == 3)
        {
            m = Friday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Friday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Friday.get(2);
            System.out.println("Dinner: "+ m.getName());
        }else if(Friday.size() == 4)
        {
            m = Friday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Friday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Friday.get(2);
            System.out.println("Evening meal: "+ m.getName());
            m = Friday.get(3);
            System.out.println("Dinner: "+ m.getName());
        }else if(Friday.size() == 5)
        {
            m = Friday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Friday.get(1);
            System.out.println("Brunch: "+ m.getName());
            m = Friday.get(2);
            System.out.println("Lunch: "+ m.getName());
            m = Friday.get(3);
            System.out.println("Evening meal: "+ m.getName());
            m = Friday.get(4);
            System.out.println("Dinner: "+ m.getName());
        }
        
        System.out.println("Saturday: ");
        
        if(Saturday.size() == 3)
        {
            m = Saturday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Saturday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Saturday.get(2);
            System.out.println("Dinner: "+ m.getName());
        }else if(Saturday.size() == 4)
        {
            m = Saturday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Saturday.get(1);
            System.out.println("Lunch: "+ m.getName());
            m = Saturday.get(2);
            System.out.println("Evening meal: "+ m.getName());
            m = Saturday.get(3);
            System.out.println("Dinner: "+ m.getName());
        }else if(Saturday.size() == 5)
        {
            m = Saturday.get(0);
            System.out.println("Breakfast: "+ m.getName());
            m = Saturday.get(1);
            System.out.println("Brunch: "+ m.getName());
            m = Saturday.get(2);
            System.out.println("Lunch: "+ m.getName());
            m = Saturday.get(3);
            System.out.println("Evening meal: "+ m.getName());
            m = Saturday.get(4);
            System.out.println("Dinner: "+ m.getName());
        }
        
        System.out.println("Synday: Its a <<cheat>> day where you can eat whatever you want.");
        
        return;
    }
    
    private void Make_changes() //Methodos gia tis allages toy kwdika vasei epilogwn tou xrhsth
    {
        System.out.println("Do you want to make any changes to the plan that was made?(Answer with 'y' for to make a change or 'n' to not)");
        
        Scanner input = new Scanner(System.in);
        
        String choice = input.nextLine();
        
        String day;
        
        if((choice == "y") || (choice == "yes") || (choice == "Y") || (choice == "YES"))
        {
            System.out.println("Please choose the day you want to change.");
            
            day = input.nextLine();
            
            System.out.println("Please choose the new day to change to.");
            
            choice = input.nextLine();
            
            switch(choice) //Switch poy vasei twn dyo hmerwn poy epelexe o xrhsths ginetai enallagh twn stoixeiwn tous
            {
                case "monday":
                          ArrayList<Meal> temp1 = new ArrayList<Meal>(Monday);
                          switch(day)
                          {
                               case "tuesday":
                                        Monday.clear();
                                        Monday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp1);
                                        break;
                               case "wednesday":
                                        Monday.clear();
                                        Monday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp1);
                                        break;
                               case "thursday":
                                        Monday.clear();
                                        Monday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp1);
                                        break;
                               case "friday":
                                        Monday.clear();
                                        Monday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp1);
                                        break;
                               case "saturday":
                                        Monday.clear();
                                        Monday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp1);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "tuesday":
                          ArrayList<Meal> temp2 = new ArrayList<Meal>(Tuesday); 
                          switch(day)
                          {
                               case "monday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp2);
                                        break;
                               case "wednesday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp2);
                                        break;
                               case "thursday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp2);
                                        break;
                               case "friday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp2);
                                        break;
                               case "saturday":
                                        Tuesday.clear();
                                        Tuesday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp2);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "wednesday":
                          ArrayList<Meal> temp3 = new ArrayList<Meal>(Wednesday);
                          switch(day)
                          {
                               case "monday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp3);
                                        break;
                               case "tuesday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp3);
                                        break;
                               case "thursday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp3);
                                        break;
                               case "friday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp3);
                                        break;
                               case "saturday":
                                        Wednesday.clear();
                                        Wednesday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp3);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "thursday":
                          ArrayList<Meal> temp4 = new ArrayList<Meal>(Thursday);
                          switch(day)
                          {
                               case "monday":
                                        Thursday.clear();
                                        Thursday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp4);
                                        break;
                               case "tuesday":
                                        Thursday.clear();
                                        Thursday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp4);
                                        break;
                               case "wednesday":
                                        Thursday.clear();
                                        Thursday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp4);
                                        break;
                               case "friday":
                                        Thursday.clear();
                                        Thursday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp4);
                                        break;
                               case "saturday":
                                        Thursday.clear();
                                        Thursday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp4);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "friday":
                          ArrayList<Meal> temp5 = new ArrayList<Meal>(Friday);
                          switch(day)
                          {
                               case "monday":
                                        Friday.clear();
                                        Friday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp5);
                                        break;
                               case "tuesday":
                                        Friday.clear();
                                        Friday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp5);
                                        break;
                               case "wednesday":
                                        Friday.clear();
                                        Friday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp5);
                                        break;
                               case "thursday":
                                        Saturday.clear();
                                        Saturday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp5);
                                        break;
                               case "saturday":
                                        Friday.clear();
                                        Friday.addAll(Saturday);
                                        Saturday.clear();
                                        Saturday.addAll(temp5);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                case "saturday":
                          ArrayList<Meal> temp6 = new ArrayList<Meal>(Saturday);
                          switch(day)
                          {
                               case "monday":
                                        Saturday.clear();
                                        Saturday.addAll(Monday);
                                        Monday.clear();
                                        Monday.addAll(temp6);
                                        break;
                               case "tuesday":
                                        Saturday.clear();
                                        Saturday.addAll(Tuesday);
                                        Tuesday.clear();
                                        Tuesday.addAll(temp6);
                                        break;
                               case "wednesday":
                                        Saturday.clear();
                                        Saturday.addAll(Wednesday);
                                        Wednesday.clear();
                                        Wednesday.addAll(temp6);
                                        break;
                               case "thursday":
                                        Saturday.clear();
                                        Saturday.addAll(Thursday);
                                        Thursday.clear();
                                        Thursday.addAll(temp6);
                                        break;
                               case "friday":
                                        Saturday.clear();
                                        Saturday.addAll(Friday);
                                        Friday.clear();
                                        Friday.addAll(temp6);
                                        break;
                               default:
                                        System.out.println("No match for the day you chose to change to.");
                          }
                          break;
                default:
                          System.out.println("No match for the day you chose to change.");
            }
        }else
        {
            System.out.println("You selected to make no changes an so the plan will be saved to your profile.");
            return;
        }
        
        return;
    }
    
    private void Save_plan(User_profile u) //Apothikeysh toy programmatos sto profile tou xrhsth
    {
        u.setFoodMonday(Monday);
        u.setFoodTuesday(Tuesday);
        u.setFoodWednesday(Wednesday);
        u.setFoodThursday(Thursday);
        u.setFoodFriday(Friday);
        u.setFoodSaturday(Saturday);
        
        System.out.println("The plan was saved to your profile.");
        return;
    }
}