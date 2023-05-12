import java.util.Scanner;

public class main
{
    public static void main()
    {
        System.out.println("Main menu:");
        System.out.print("1)Make plan of diet and exercise\n2)Calorie counter\n3)Place order\n4)Track order\n5)Check your profile\n6)Daily awards\n7)Eshop(admin only)\n8)Forum\n");
        
        Scanner input = new Scanner(System.in);
        
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
                break;
            case 2:
                System.out.println("Calorie counter.");
                break;
            case 3:
                System.out.println("Place order.");
                break;
            case 4:
                System.out.println("Track order.");
                break;
            case 5:
                System.out.println("Check your profile.");
                break;
            case 6:
                System.out.println("Daily awards.");
                break;
            case 7:
                System.out.println("Eshop(admin only).");
                break;
            case 8:
                System.out.println("Forum.");
                break;
        }
    }
}