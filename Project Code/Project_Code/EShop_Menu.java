import java.util.Scanner;
public class EShop_Menu {
    static void eshopStart(){
        System.out.println("1.Browse Shop, 2.Order Tracking");
        Scanner input = new Scanner(System.in);
               int choice2 = input.nextInt();
               switch (choice2){ 
                   case 1: EShop_Menu.openEShop(); break;
                   case 2: EShop_Menu.openTracker(); break;
                   default: break;
}
        
        
    }

    
static void openEShop() {
        Shop shop = new Shop();//apo to menou tou eshop pame sto shop kommati tou
        shop.browseShop();
    }

   static void openTracker(){
    Order_Tracker orderTracker = new Order_Tracker();//apo to menou tou eshop pame sto order tracking kommati tou
    orderTracker.track_ordering();
}
}