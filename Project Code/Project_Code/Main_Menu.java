
import java.util.*;

public class Main_Menu 
{
    static ArrayList<Food> FoodList = new ArrayList<Food>();
    static ArrayList<Drink> DrinksList = new ArrayList<Drink>();
    static ArrayList<Exercise> ExerciseList = new ArrayList<Exercise>();
    static ArrayList<Meal> MealList = new ArrayList<Meal>();
    static ArrayList<User_profile> UserList =new ArrayList<User_profile>();
    static ArrayList<Products> products = new ArrayList<Products>();
    
    public static void Main_Menu()
    {
        ExerciseList_init(); Lists_init();
        User_ProfileList_init();
        initializeProducts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a user or an admin;(Write which one using lower case letters)");
        String choice1 = scanner.nextLine();
        if(choice1.equalsIgnoreCase("user")){
             User_profile u = User_profile.login(UserList);
             List<String> userPostList = u.getUserPostList();
             List<String> userMessageList = u.getUserMessageList();
             List<String> userConnectionsList = u.getUserConnectionsList();
             int count = 1;
             while(count == 1)
             {
                System.out.println("Main menu:");
                System.out.print("1)Make plan of diet and exercise\n2)Calorie counter\n3)E-Shop\n4)Check your profile\n5)Daily awards\n6)Forum\n7)Exit\n");
        
                Scanner input = new Scanner(System.in);
        
                System.out.println("Select one of the apps functions by the corresponding number only.");
        
                int choice = input.nextInt();
        
               while(choice > 7 || choice < 1)
               {
                  System.out.println("Your choice was invalid. Please make another one using the numbers 1 to 8 that correspond to the functions.");
                  choice = input.nextInt();
               }
        
               switch(choice)
               {
                case 1:
                    System.out.println("Make plan of diet and exercise.");
                    Plan.New_Plan(u,ExerciseList,MealList);
                    System.out.println(".\n");
                    break;
                case 2:
                    System.out.println("Calorie counter.");
                    Calorie_Counter.CounterStartUp(FoodList, DrinksList, ExerciseList);
                    break;
                case 3:
                    System.out.println("E-shop.");
                    EShop_Menu.eshopStart(u);
                    break;
                case 4:
                    System.out.println("Check and update your profile.");
                    u.CheckProfile();
                    break;
                case 5:
                    System.out.println("Daily awards.");
                    Rewards.DailyRewards(ExerciseList,u);
                    break;
                case 6:
                    System.out.println("Forum.");
                    Forum.forum(u,UserList,userMessageList,userConnectionsList,userPostList);
                    break;
                case 7:
                    System.out.println("Good-bye. Do not forget to follow your plans.");
                    count = 0;
                    break;
               }
             }
        }
        else if(choice1.equalsIgnoreCase("admin")){
            User_profile admin = User_profile.login(UserList);
            List<String> userPostList = admin.getUserPostList();
            List<String> userMessageList = admin.getUserMessageList();
            List<String> userConnectionsList = admin.getUserConnectionsList();
            if(admin.getAdmin()==true){
                int count = 1;
                while(count == 1)
                {
                  System.out.println("Main menu:");
                  System.out.print("1)Make plan of diet and exercise\n2)Calorie counter\n3)E-Shop\n4)Check your profile\n5)Daily awards\n6)Eshop(admin only)\n7)Forum\n8)Exit\n");
        
                  Scanner input = new Scanner(System.in);
                  Scanner scanner2 = new Scanner(System.in);
        
                  System.out.println("Select one of the apps functions by the corresponding number only.");
        
                  int choice = input.nextInt();
        
                  while(choice > 8 || choice < 1)
                  {
                    System.out.println("Your choice was invalid. Please make another one using the numbers 1 to 8 that correspond to the functions.");
                    choice = input.nextInt();
                  }
        
                  switch(choice)
                  {
                    case 1:
                      System.out.println("Make plan of diet and exercise.");
                       Plan.New_Plan(admin,ExerciseList,MealList);
                       System.out.println(".\n");
                       break;
                    case 2:
                       System.out.println("Calorie counter.");
                       Calorie_Counter.CounterStartUp(FoodList, DrinksList, ExerciseList);
                       break;
                    case 3:
                       System.out.println("E-shop.");
                       EShop_Menu.eshopStart(admin);
                       break;
                    case 4:
                       System.out.println("Check and update your profile.");
                       admin.CheckProfile();
                       break;
                    case 5:
                       System.out.println("Daily awards.");
                       Rewards.DailyRewards(ExerciseList,admin);
                       break;
                    case 6:
                       System.out.println("Eshop(admin only).");
                       EShop.editEshop(scanner,scanner2,products);
                       break;
                    case 7:
                       System.out.println("Forum.");
                       Forum.forum(admin,UserList,userMessageList,userConnectionsList,userPostList);
                       break;
                    case 8:
                       System.out.println("Good-bye. Do not forget to follow your plans.");
                       count = 0;
                       break;
                 }
               }
            }
            else if(admin.getAdmin()==false){
                System.out.println("You are not the admin");
                return;
            }
        }
    }
    
    private static void User_ProfileList_init()
    {
        User_profile u1 = new User_profile("Nikos","nikos1",22,"nikos@gmail.com","male",183,3581,590,70,10,"Silver", "Weightlifting",false); 
        User_profile u2 = new User_profile("Stamatis","stamatis1",22,"stamatis@gmail.com","male",185,3582,230,82,10,"Silver","Trx",false); 
        User_profile u3 = new User_profile("Giannis","giannis1",22,"giannis@gmail.com","male",185,3583,300,75,10,"Silver","Crossfit",false); 
        User_profile u4 = new User_profile("Dimitris","dimitris1",22,"dimitris@gmail.com","male",183,3584,610,90,10,"Gold","Whatever",false);
        User_profile admin1 = new User_profile("Kogias","kogias1",28,"kogias@gmail.com","male",180,3580,800,80,10,"Gold","Calisthenics",true);
        User_profile admin2 = new User_profile("Slidis","slidis1",28,"slidis@gmail.com","male",188,3580,800,95,10,"Gold","Calisthenics",true);
        UserList.add(u1); UserList.add(u2); UserList.add(u3); UserList.add(u4);
        UserList.add(admin1); UserList.add(admin2);
    }
    
    private static void ExerciseList_init()
    {
        Exercise e1 = new Exercise("Bench press", "Chest", 45, "Weights"); Exercise e2 = new Exercise("Push up", "Chest", 32, "Weights"); Exercise e3 = new Exercise("Machine Fly", "Chest", 36, "Weights"); Exercise e4 = new Exercise("Cable crossover", "Chest", 36, "Weights");
        Exercise e5 = new Exercise("Pull up", "Back", 80, "Weights"); Exercise e6 = new Exercise("Deadlift", "Back", 60, "Weights"); Exercise e7 = new Exercise("Cable rows", "Back", 94, "Weights"); Exercise e8 = new Exercise("Pull down", "Back", 50, "Weights");
        Exercise e9 = new Exercise("Leg extensions", "Legs", 40, "Weights"); Exercise e10 = new Exercise("Leg curl", "Legs", 40, "Weights"); Exercise e11 = new Exercise("Squat", "Legs", 32, "Weights"); Exercise e12 = new Exercise("Leg press", "Legs", 35, "Weights");
        Exercise e13 = new Exercise("Overhead pres", "Shoulders", 36,"Weights"); Exercise e14 = new Exercise("Lateral raise", "Shoulders", 36,"Weights"); Exercise e15 = new Exercise("Front raise", "Shoulders", 31,"Weights"); Exercise e16 = new Exercise("Shoulder press", "Shoulders", 36,"Weights");
        Exercise e17 = new Exercise("Bicep curl","Biceps", 33,"Weights"); Exercise e18 = new Exercise("Hammer curl","Biceps", 36,"Weights"); Exercise e19 = new Exercise("Ez-bar curl","Biceps", 35,"Weights");
        Exercise e20 = new Exercise("Triceps extensions","Triceps", 40,"Weights"); Exercise e21 = new Exercise("Triceps cable pushdown","Triceps", 32,"Weights"); Exercise e22 = new Exercise("Dumbell kickbacks","Triceps", 33,"Weights");
        Exercise e23 = new Exercise("Crunches","Abs", 25,"Weights"); Exercise e24 = new Exercise("Plank","Abs", 5,"Weights"); Exercise e25 = new Exercise("Leg raises","Abs", 40,"Weights");
        Exercise e26 = new Exercise("Rowing","All", 150,"Medium Cardio"); Exercise e27 = new Exercise("Jump rope","All", 275,"High Cardio"); Exercise e28 = new Exercise("Jumping jacks","All", 120,"Medium Cardio");
        Exercise e29 = new Exercise("5km Run","All", 300,"High Cardio"); Exercise e30 = new Exercise("10km Run","All", 600,"High Cardio"); Exercise e31 = new Exercise("Burpees","All", 50,"Low Cardio");
        Exercise e32 = new Exercise("1km Run","All", 60,"Low Cardio"); Exercise e33 = new Exercise("Eliptical","All", 170,"Medium Cardio"); Exercise e34 = new Exercise("Squat jump","All", 80,"Low Cardio");
        Exercise e35 = new Exercise("Leg stretches","All", 25,"Flexibility"); Exercise e36 = new Exercise("Quad stretch","All", 25,"Flexibility"); Exercise e37 = new Exercise("Shoulder stretch","All", 25,"Flexibility");
        Exercise e38 = new Exercise("Knee to chest stretch","All", 25,"Flexibility"); Exercise e39 = new Exercise("Lizard Pose","All", 25,"Flexibility"); Exercise e40 = new Exercise("Split","All", 25,"Flexibility");
        Exercise e41 = new Exercise("Cat cow","All", 25,"Flexibility"); Exercise e42 = new Exercise("Arm stretch","All", 25,"Flexibility"); Exercise e43 = new Exercise("Seated hamstring","All", 25,"Flexibility");
        
        ExerciseList.add(e1); ExerciseList.add(e2); ExerciseList.add(e3); ExerciseList.add(e4); ExerciseList.add(e5); ExerciseList.add(e6); ExerciseList.add(e7); ExerciseList.add(e8);
        ExerciseList.add(e9); ExerciseList.add(e10); ExerciseList.add(e11); ExerciseList.add(e12); ExerciseList.add(e13); ExerciseList.add(e14); ExerciseList.add(e15); ExerciseList.add(e16);
        ExerciseList.add(e17); ExerciseList.add(e18); ExerciseList.add(e19); ExerciseList.add(e20); ExerciseList.add(e21); ExerciseList.add(e22); ExerciseList.add(e23); ExerciseList.add(e24);
        ExerciseList.add(e25); ExerciseList.add(e26); ExerciseList.add(e27); ExerciseList.add(e28); ExerciseList.add(e29); ExerciseList.add(e30); ExerciseList.add(e31); ExerciseList.add(e32);
        ExerciseList.add(e33); ExerciseList.add(e34); ExerciseList.add(e35); ExerciseList.add(e36); ExerciseList.add(e37); ExerciseList.add(e38); ExerciseList.add(e39); ExerciseList.add(e40);
        ExerciseList.add(e41); ExerciseList.add(e42); ExerciseList.add(e43);
    }
    
    private static void Lists_init()
    {
        Food f1 = new Food("Bread", 265, 9, 491, 115, 0, 49, 3.2); Food f2 = new Food("Steak", 271, 25, 58, 279, 78, 0, 19); Food f3 = new Food("Feta", 264, 14, 1116, 62, 89, 4, 21); Food f4 = new Food("Potato", 110, 3, 0, 620, 0, 26, 0.1); Food f5 = new Food("Hamburger", 295, 17, 414, 226, 47, 24, 14);
        Food f6 = new Food("Mousaka", 325, 28, 0, 0, 0, 19, 15); Food f7 = new Food("Pastitsio", 152, 8, 388, 0, 0, 18, 5.3); Food f8 = new Food("Spaghetti", 220, 8, 325, 63, 0, 43, 1.3); Food f9 = new Food("Pasta with meat sauce", 329, 20, 1887, 811, 51, 33, 13.1); Food f10 = new Food("Lasagna with meat", 336, 20, 744, 391, 49, 35, 12.4);
        Food f11 = new Food("Chicken nuggets", 300, 15, 540, 240, 54, 16, 18); Food f12 = new Food("Chicken breast", 195, 30, 393, 243, 83, 0, 7.7); Food f13 = new Food("Chicken wing", 81, 7, 113, 51, 23, 0, 5.4); Food f14 = new Food("Chicken thigh", 135, 14, 223, 121, 51, 0, 8.5); Food f15 = new Food("Chicken", 237, 27, 404, 221, 87, 0, 13.5);
        Food f16 = new Food("Fruit salad", 108, 1, 11, 268, 0, 25, 1.6); Food f17 = new Food("Apples", 72, 0, 1, 148, 0, 19, 0.2); Food f18 = new Food("Bananas", 105, 1, 1, 422, 0, 27, 0.4); Food f19 = new Food("Pear", 96, 1, 2, 198, 0, 27, 0.2); Food f20 = new Food("Peaches", 38, 1, 0, 186, 0, 10, 0.2);
        Food f21 = new Food("Scrambled eggs", 199, 13, 211, 138, 400, 2, 15.2); Food f22 = new Food("Fried egg", 92, 6, 94, 68, 210, 0, 7); Food f23 = new Food("Boiled egg", 77, 6, 139, 63, 211, 1, 5.3); Food f24 = new Food("Bacon", 54, 4, 232, 56, 12, 0, 4); Food f25 = new Food("Turkey meat", 119, 22, 70, 296, 65, 0, 2.9);
        
        FoodList.add(f1); FoodList.add(f2); FoodList.add(f3); FoodList.add(f4); FoodList.add(f5); FoodList.add(f6); FoodList.add(f7); FoodList.add(f8); FoodList.add(f9); FoodList.add(f10);
        FoodList.add(f11); FoodList.add(f12); FoodList.add(f13); FoodList.add(f14); FoodList.add(f15); FoodList.add(f16); FoodList.add(f17); FoodList.add(f18); FoodList.add(f19); FoodList.add(f20);
        FoodList.add(f21); FoodList.add(f22); FoodList.add(f23); FoodList.add(f24); FoodList.add(f25);
        
        Drink d1 = new Drink("Water", 0, 0, 5, 0, 0, 0, 0); Drink d2 = new Drink("Orange juice", 45, 1, 1, 200, 0, 10, 0.2); Drink d3 = new Drink("Coca cola", 138, 0, 15, 7, 0, 35, 0); Drink d4 = new Drink("Red bull", 117, 1, 98, 8, 0, 28, 0.2); Drink d5 = new Drink("Apple juice", 120, 0, 10, 265, 0, 30, 0.3);
        Drink d6 = new Drink("Protein shake", 140, 26, 207, 114, 0, 4, 2.3); Drink d7 = new Drink("Powerade", 32, 0, 30, 0, 0, 8, 0); Drink d8 = new Drink("Mixed fruit juice", 115, 1, 5, 385, 0, 28, 0.3);  Drink d9 = new Drink("Pineapple orange banana juice", 128, 1, 2, 428, 0, 31, 0.1); Drink d10 = new Drink("Low calorie fruit drink", 46, 0, 12, 108, 0, 11, 0);
        Drink d11 = new Drink("Capuccino", 74, 4, 50, 233, 12, 6, 4); Drink d12 = new Drink("Espresso", 5, 0, 33, 273, 0, 0, 0.4); Drink d13 = new Drink("Chocolate drink", 120, 2, 222, 193, 0, 26, 1); Drink d14 = new Drink("Tea with milk and sugar", 30, 1, 14, 71, 3, 5, 0.8); Drink d15 = new Drink("Peach ice tea", 170, 0, 26, 0, 0, 40, 0);
        
        DrinksList.add(d1); DrinksList.add(d2); DrinksList.add(d3); DrinksList.add(d4); DrinksList.add(d5); DrinksList.add(d6); DrinksList.add(d7); DrinksList.add(d8); DrinksList.add(d9); DrinksList.add(d10);
        DrinksList.add(d11); DrinksList.add(d12); DrinksList.add(d13); DrinksList.add(d14); DrinksList.add(d15);
        
        Meal m1 = new Meal("Fruit salad and orange juice",f16,d2); Meal m2 = new Meal("Fruit salad and water",f16,d1); Meal m3 = new Meal("Apple and tea",f17,d14); Meal m4 = new Meal("Peaches and ice tea",f20,d15); Meal m5 = new Meal("Banana and chocolate drink",f18,d13);
        Meal m6 = new Meal("Scrambled eggs, bacon and orange juice",f21,f24,d2, "Breakfast"); Meal m7 = new Meal("Apple, banana and protein shake", f17, f18, d6, "Breakfast"); Meal m8 = new Meal("Scrambled eggs,pear and capuccino ",f21, f19,d11, "Breakfast"); Meal m9 = new Meal("Scrambled eggs,fruit salad and protein shake",f21, f16,d6, "Breakfast"); Meal m10 = new Meal("Potato, fried egg and orange juice",f4, f22,d2, "Breakfast");
        Meal m11 = new Meal("Apple, banana and orange juice",f17,f18,d2, "Brunch"); Meal m12 = new Meal("Peaches, pear and protein shake",f19,f20,d6, "Brunch"); Meal m13 = new Meal("Fruit salad, pear, capuccino",f16,f19,d11, "Brunch"); Meal m14 = new Meal("Scrambled eggs, pear and powerade",f21,f19,d7, "Brunch"); Meal m15 = new Meal("Apple, peaches and ice tea",f17,f20,d15, "Brunch");
        Meal m16 = new Meal("Mousaka, potato, bread and coca cola",f6, f4, f1, d3, "Lunch"); Meal m17 = new Meal("Lasagna, chicken nuggets, bread and ice tea",f10, f11, f1, d15, "Lunch"); Meal m18 = new Meal("Chicken, feta, potato and water",f15,f4,f3,d1, "Lunch"); Meal m19 = new Meal("Pastitsio, banana, bread and protein shake",f7,f18,f1,d6, "Lunch"); Meal m20 = new Meal("Chicken wing, fried egg, spaghetti and orange juice",f22,f8,f13,d2, "Lunch");
        Meal m21 = new Meal("Chicken breast, potato, bread and tea",f12, f4, f1, d14, "Dinner"); Meal m22 = new Meal("Pasta, feta, bread and coca cola",f9, f3, f1, d3, "Dinner"); Meal m23 = new Meal("Scrambled eggs, bacon, bread and orange juice",f21, f24, f1, d2, "Dinner"); Meal m24 = new Meal("Steak, spaghetti, nuggets and coca cola",f2, f8, f11, d3, "Dinner"); Meal m25 = new Meal("Chicken thigh, potato, feta and apple juice",f14, f4, f3, d5, "Dinner");
        
        MealList.add(m1); MealList.add(m2); MealList.add(m3); MealList.add(m4); MealList.add(m5); MealList.add(m6); MealList.add(m7); MealList.add(m8); MealList.add(m9); MealList.add(m10);
        MealList.add(m11); MealList.add(m12); MealList.add(m13); MealList.add(m14); MealList.add(m15); MealList.add(m16); MealList.add(m17); MealList.add(m18); MealList.add(m19); MealList.add(m20);
        MealList.add(m21); MealList.add(m22); MealList.add(m23); MealList.add(m24); MealList.add(m25);
    }
    
    public static void initializeProducts() {
     
       
        // Supplements
        products.add(new Products("Protein Powder 1", 29.99, "Supplements",50));
        products.add(new Products("Protein Powder 2", 39.99, "Supplements",40));
        products.add(new Products("Pre-Workout 1", 29.99, "Supplements",100));
        products.add(new Products("Pre-Workout 2", 39.99, "Supplements",60));
        products.add(new Products("Magnesium", 19.99, "Supplements",150));

        // Clothes
        products.add(new Products("T-Shirt", 19.99, "Clothes",80));
        products.add(new Products("Shorts", 24.99, "Clothes",90));
        products.add(new Products("Leggings", 29.99, "Clothes",70));
        products.add(new Products("Hoodie", 39.99, "Clothes",65));
        products.add(new Products("Jacket", 49.99, "Clothes",30));

        // Shoes
        products.add(new Products("Running Shoes", 79.99, "Shoes",50));
        products.add(new Products("Training Shoes", 89.99, "Shoes",30));
        products.add(new Products("Basketball Shoes", 99.99, "Shoes",40));
        products.add(new Products("Sneakers", 69.99, "Shoes",20));
        products.add(new Products("Sandals", 39.99, "Shoes",40));

        // Accessories
        products.add(new Products("Gym Bag", 39.99, "Accessories",30));
        products.add(new Products("Water Bottle", 9.99, "Accessories",50));
        products.add(new Products("Yoga Mat", 19.99, "Accessories",60));
        products.add(new Products("Resistance Bands", 14.99, "Accessories",100));
        products.add(new Products("Gloves", 14.99, "Accessories",40));

        // Gear
        products.add(new Products("Dumbbells", 49.99, "Gear",50));
        products.add(new Products("Jump Rope", 9.99, "Gear",20));
        products.add(new Products("Exercise Ball", 29.99, "Gear",15));
        products.add(new Products("Foam Roller", 19.99, "Gear",30));
        products.add(new Products("Weight Bench", 149.99, "Gear",20));
    }
    
    
}