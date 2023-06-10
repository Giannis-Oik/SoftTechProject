import java.util.Scanner;
import java.util.ArrayList;
public class EShop_Menu {
   public static ArrayList<Order> orderList = new ArrayList<Order>();
   static void eshopStart(User_profile u){
        System.out.println("1.Browse Shop, 2.Order Tracking");
        Scanner input = new Scanner(System.in);
        int choice2 = input.nextInt();
        switch (choice2){ 
            case 1: EShop_Menu.openEShop(u); break;
            case 2: EShop_Menu.openTracker(); break;
            default: break;
        }
   }

    
   static void openEShop(User_profile u) {
        Shop shop = new Shop();//apo to menou tou eshop pame sto shop kommati tou
        shop.browseShop(u);
   }

   static void openTracker(){
   
       Order_Tracker orderTracker = new Order_Tracker(orderList);//apo to menou tou eshop pame sto order tracking kommati tou

       orderTracker.track_ordering();
   }
}