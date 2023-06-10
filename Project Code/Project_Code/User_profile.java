import java.util.*;


public class User_profile extends User
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
    
    private String email, sex, type;
    private int age, height, certificate;
    private double weight, certDiscount;
    
    
    public static ArrayList<String> userMessageList = new ArrayList<String>(); ;
    public ArrayList<String> userPostList = new ArrayList<String>();
    public ArrayList<String> userConnectionsList = new ArrayList<String>();
    public static void User_Messages_init(){
       String message1 = new String("Geia");
       String message2 = new String("Geia ti kaneis?");
       userMessageList.add(message1);
       userMessageList.add(message2);
    }
    private boolean admin;
    public int points;
    public String category;
    
    public User_profile(String name,String password)
    {
        super(name,password);
    }
    
    public User_profile(String name,String password, int age, String email, String sex, int height, int cert, int points, double weight, double certDisc, String category, String type,boolean admin)
    {
        super(name,password);
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.height = height;
        this.certificate = cert;
        this.points = points;
        this.weight = weight;
        this.certDiscount = certDisc;
        this.category = category;
        this.type = type; 
        this.admin = admin;
        this.userMessageList=userMessageList;
        this.userPostList=userPostList;
        this.userConnectionsList=userConnectionsList;
    }
    
    public static User_profile login(ArrayList<User_profile> UserList)
    {
        System.out.println("Welcome to Fitness App! \n");
        Scanner input1=new Scanner(System.in);
        System.out.println("Give your username and password to log in: ");
        System.out.print("Username: ");
        String name=input1.nextLine();
        System.out.print("Password: ");
        String password = input1.nextLine();
        User_profile user = new User_profile(name,password);
        boolean found = false;
        found = checkIfExists(UserList, name);
        
        if(found)
        {
            boolean pass = false;
            for(User_profile u:UserList)
            {
                if(password.equals(u.getProfilePassword()))
                {
                    System.out.println("Login succesful.");
                    user = u;
                    pass = true;
                    break;
                }
            }
            
            if(!pass)
            {
                System.out.println("Wrong password, please try again.");
                System.exit(0);
            }
        }else
        {
            System.out.println("User doesnt exist or the username was wrong.");
            System.out.println("Do you want to create a new profile or try again?(Answer with y or n)");
            String choice = input1.nextLine();
     
            if((choice.equalsIgnoreCase("yes")) || (choice.equalsIgnoreCase("y")))
            {
                user.Create_profile();
                user.giveCertificate();
                user.giveWorkoutType();
                UserList.add(user);
            }else
            {
                System.out.println("Thank you. Bye.");
                System.exit(0);
            }
        }
        
        return user;
    }
    
    private static boolean checkIfExists(ArrayList<User_profile> UserList,String name) 
    {
        for(User_profile user:UserList)
        {
            if(name.equals(user.getProfileName()))
            {
                return true;
            }
        }
        return false;
    }
    
    private void Create_profile()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Give your email: ");
        String email = input.nextLine();
        this.setProfileEmail(email);
        System.out.print("Give your age: ");
        int age = input.nextInt();
        while(age < 1 || age > 99)
        {
            System.out.println("Invalid age choice. Please insert a value between 1 and 99.");
            age = input.nextInt();
        }
        this.setProfileAge(age);
        Scanner scan = new Scanner(System.in);
        System.out.print("Give your sex: ");
        String sex = scan.nextLine();
        this.setProfileSex(sex);
        System.out.print("Give your height(in cms without comma): ");
        int height = input.nextInt();
        while(height < 0 || height > 250)
        {
            System.out.println("Invalid height choice. Please insert a value between 0 and 250.");
            height = input.nextInt();
        }
        this.setProfileHeight(height);
        System.out.print("Give your weight(in kgs, for example 78.50): ");
        double weight = input.nextDouble();
        while(weight < 0)
        {
            System.out.println("Invalid weight choice. Please insert a value over 0.");
            weight = input.nextInt();
        }
        this.setProfileWeight(weight);    
    }
    
    public void giveCertificate()
    {
        Scanner input0=new Scanner(System.in);
        System.out.println("Do you have any certificate (Unemployed, student) that would make you eligible for a discount?(Answer with y or n)");
        String choice = input0.nextLine();
        
        if((choice.equalsIgnoreCase("y")) || (choice.equalsIgnoreCase("yes")))
        {
            System.out.println("Please give your certificate number: ");
            int id = input0.nextInt();
            this.certificate = id;
            this.certDiscount = 10.00;
        }
    }
    
    public void giveWorkoutType()
    {
        Scanner input0=new Scanner(System.in);
        System.out.println("Please insert which type of workout you prefer(Gymnastics, weightlifting, crossfit, trx, whatever): ");
        String choice = input0.nextLine();
        
        if((choice.equalsIgnoreCase("gymnastics")) || (choice.equalsIgnoreCase("weightlifting")) || (choice.equalsIgnoreCase("crossfit")) || (choice.equalsIgnoreCase("trx")))
        {
            this.type = choice;
        }else { this.type = "Whatever"; }
    }
    
    public void CheckProfile()
    {
        System.out.println("Select one of the following:\n1)See your profile\n2)Update your profile\n3)Return to main menu\n ");
        Scanner sc1 = new Scanner(System.in);
        int choice = sc1.nextInt();
        
        while(choice > 3 || choice < 1)
        {
            System.out.println("Your choice was invalid. Please make another one using the numbers 1 to 3.");
            choice = sc1.nextInt();
        }
        
        switch(choice)
        {
            case 1:
               System.out.println("Your profile: ");
               this.ShowProfile();
               break;
            case 2:
               this.updateProfile();
               break;
            case 3:
               return;
        }   
    }
    
    public void updateProfile()
    {
        System.out.println("Select which one you want to change from the corresponding number:\n1)Age\n2)Height\n3)Weight\n4)Certificate\n5)Email\n6)Type of workout\n7)No changes");
        Scanner sc=new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
               System.out.println("Insert the new age value: ");
               int age = sc.nextInt();
               while(age < 1 || age > 99)
               {
                   System.out.println("Invalid age choice. Please insert a value between 1 and 99.");
                   age = sc.nextInt();
               }
               this.age = age;
               break;
            case 2:
               System.out.println("Insert the new height value(in cm with no commas): ");
               int height = sc.nextInt();
               while(height < 0 || height > 250)
               {
                   System.out.println("Invalid height choice. Please insert a value between 0 and 250.");
                   height = sc.nextInt();
               }
               this.height = height;
               break;
            case 3:
               System.out.println("Insert the new weight value in kgs(if needed add comma(,)): ");
               double weight = sc.nextDouble();
               while(weight < 0)
               {
                   System.out.println("Invalid weight choice. Please insert a value over 0.");
                   weight = sc.nextInt();
               }
               break;
            case 4:
               System.out.println("Insert the new certificate value: ");
               int certificate = sc.nextInt();
               this.certificate = certificate;
               break;
            case 5:
               System.out.println("Insert the new email value: ");
               String mail = sc.nextLine();
               this.email = mail;
               break;
            case 6:
               System.out.println("Insert the new type of workout value: ");
               String typeof = sc.nextLine();
               if((typeof.equalsIgnoreCase("gymnastics")) || (typeof.equalsIgnoreCase("weightlifting")) || (typeof.equalsIgnoreCase("crossfit")) || (typeof.equalsIgnoreCase("trx")))
               {
                   this.type = typeof;
               }else { this.type = "Whatever"; }
               break;
            case 7:
               return;
        }   
        
        System.out.println("Your changed profile is: ");
        this.ShowProfile();
    }
    
    public boolean CheckIfPlanExists()
    {
        if((this.ExMonday.isEmpty()) && (this.ExTuesday.isEmpty()) && (this.ExWednesday.isEmpty()) && (this.ExThursday.isEmpty()) && (this.ExFriday.isEmpty()) && (this.ExSaturday.isEmpty()))
        {
            return false;
        }else {return true;}
    }
    
    public void DeletePlan()
    {
        this.ExMonday.clear(); this.ExTuesday.clear(); this.ExWednesday.clear(); this.ExThursday.clear(); this.ExFriday.clear(); this.ExSaturday.clear();
        this.FoodMonday.clear(); this.FoodTuesday.clear(); this.FoodWednesday.clear(); this.FoodThursday.clear(); this.FoodFriday.clear(); this.FoodSaturday.clear();
    }
    
    public void ShowProfile()
    {
        System.out.println("Username: " + this.getProfileName());
        System.out.println("Email: " + this.getProfileEmail());
        System.out.println("Age: " + this.getProfileAge());
        System.out.println("Sex: " + this.getProfileSex());
        System.out.println("Certificate: " + this.getProfileCertificate());
        System.out.println("Discount: " + this.getProfileDiscount());
        System.out.println("Height: " + this.getProfileHeight());
        System.out.println("Weight: " + this.getProfileWeight());
        System.out.println("Type of workout: " + this.getProfileType());
        System.out.println("Points: " + this.getProfilePoints());
        System.out.println("Category: " + this.getProfileCategory());
    }
    
    //Get and set methods:
    public ArrayList<String> getUserMessageList() {
        return userMessageList;
    }
    
    public void setUserMessageList(ArrayList<String> UserMessagesList2){
        UserMessagesList2.addAll(UserMessagesList2);
    }
    
    public ArrayList<String> getUserConnectionsList() {
        return userConnectionsList;
    }
    
    public void setUserConnectionsList(ArrayList<String> UserConnectionsList2){
        UserConnectionsList2.addAll(UserConnectionsList2);
    }
    
    public ArrayList<String> getUserPostList() {
        return userPostList;
    }
    
    public void setUserPostList(ArrayList<String> UserPostList2){
        UserPostList2.addAll(UserPostList2);
    }
    
   
    public boolean getAdmin(){
        return admin;
    }
    
    public String getProfileType()
    {
        return type;
    }
    
    public String getProfileName()
    {
        return Name;
    }
    
    public String getProfilePassword()
    {
        return Password;
    }
    
    public void setProfileName(String profileName)
    {
        this.Name = profileName;
    }
    
    public void setProfilePassword(String profilePassword)
    {
        this.Password = profilePassword;
    }
    
    public String getProfileEmail()
    {
        return email;
    }
    
    public int getProfileAge()
    {
        return age;
    }
    
    public String getProfileSex()
    {
        return sex;
    }
    
    public int getProfileHeight()
    {
        return height;
    }
    
    public double getProfileWeight()
    {
        return weight;
    }
    
    public double getProfileDiscount()
    {
        return certDiscount;
    }
    
    public int getProfileCertificate()
    {
        return certificate;
    }
    
    public String getProfileCategory()
    {
        return category;
    }
    
    public int getProfilePoints()
    {
        return points;
    }
    
    public void setProfileEmail(String profileEmail)
    {
        this.email = profileEmail;
    }
    
    public void setProfileAge(int profileAge)
    {
        this.age = profileAge;
    }
    
    public void setProfileSex(String profileSex)
    {
        this.sex = profileSex;
    }
    
    public void setProfileHeight(int profileHeight)
    {
        this.height = profileHeight;
    }
    
    public void setProfileWeight(double profileWeight)
    {
        this.weight = profileWeight;
    }
    
    public void setProfileCertificate(int profileCertificate)
    {
        this.certificate = profileCertificate;
    }
    
    public void setProfileCategory(String profileCategory)
    {
        this.category = profileCategory;
    }
    
    public void setProfilePoints(int profilePoints)
    {
        this.points = profilePoints;
    }
    
    public void setProfileDiscount(double profileDiscount)
    {
        this.certDiscount=profileDiscount;
    }
    
    public ArrayList getExMonday()
    {
        return ExMonday;
    }
    
    public void setExMonday(ArrayList<Exercise> list)
    {
        this.ExMonday.clear();
        this.ExMonday.addAll(list);
        
        return;
    }
    
    public ArrayList getExTuesday()
    {
        return ExTuesday;
    }
    
    public void setExTuesday(ArrayList<Exercise> list)
    {
        this.ExTuesday.clear();
        this.ExTuesday.addAll(list);
        
        return;
    }
    
    public ArrayList getExWednesday()
    {
        return ExWednesday;
    }
    
    public void setExWednesday(ArrayList<Exercise> list)
    {
        this.ExWednesday.clear();
        this.ExWednesday.addAll(list);
        
        return;
    }
    
    public ArrayList getExThursday()
    {
        return ExThursday;
    }
    
    public void setExThursday(ArrayList<Exercise> list)
    {
        this.ExThursday.clear();
        this.ExThursday.addAll(list);
        
        return;
    }
    
    public ArrayList getExFriday()
    {
        return ExFriday;
    }
    
    public void setExFriday(ArrayList<Exercise> list)
    {
        this.ExFriday.clear();
        this.ExFriday.addAll(list);
        
        return;
    }
    
    public ArrayList getExSaturday()
    {
        return ExSaturday;
    }
    
    public void setExSaturday(ArrayList<Exercise> list)
    {
        this.ExSaturday.clear();
        this.ExSaturday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodMonday()
    {
        return FoodMonday;
    }
    
    public void setFoodMonday(ArrayList<Meal> list)
    {
        this.FoodMonday.clear();
        this.FoodMonday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodTuesday()
    {
        return FoodTuesday;
    }
    
    public void setFoodTuesday(ArrayList<Meal> list)
    {
        this.FoodTuesday.clear();
        this.FoodTuesday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodWednesday()
    {
        return FoodWednesday;
    }
    
    public void setFoodWednesday(ArrayList<Meal> list)
    {
        this.FoodWednesday.clear();
        this.FoodWednesday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodThursday()
    {
        return FoodThursday;
    }
    
    public void setFoodThursday(ArrayList<Meal> list)
    {
        this.FoodThursday.clear();
        this.FoodThursday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodFriday()
    {
        return FoodFriday;
    }
    
    public void setFoodFriday(ArrayList<Meal> list)
    {
        this.FoodFriday.clear();
        this.FoodFriday.addAll(list);
        
        return;
    }
    
    public ArrayList getFoodSaturday()
    {
        return FoodSaturday;
    }
    
    public void setFoodSaturday(ArrayList<Meal> list)
    {
        this.FoodSaturday.clear();
        this.FoodSaturday.addAll(list);
        
        return;
    }
}