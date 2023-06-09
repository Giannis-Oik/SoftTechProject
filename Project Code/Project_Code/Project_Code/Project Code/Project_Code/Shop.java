import java.util.ArrayList;
import java.util.Scanner;
public class Shop extends EShop_Menu{
   private boolean active;
    private boolean checkout;
     public static ArrayList<Products> products;

   public Shop() {
        active = true;
        checkout = false;
        products = new ArrayList<>();
   }
   
      public static ArrayList<Products> getAvailableProducts() {
        return products;
    }
   
   private void showProducts(String category, ArrayList<Products> products ) {
    System.out.println("Available products in the " + category + " category:");
    for (int i = 0; i < products.size(); i++) {
        Products product = products.get(i);
        if (product.getCategory().equals(category)) {
            System.out.println("ID: " + (i + 1));
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }
    }
   }
    
   private String chooseCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a category:");
        System.out.println("1. Supplements");
        System.out.println("2. Clothes");
        System.out.println("3. Shoes");
        System.out.println("4. Accessories");
        System.out.println("5. Gear");
        System.out.print("Enter the number of the category (0 to exit): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "Supplements";
            case 2:
                return "Clothes";
            case 3:
                return "Shoes";
            case 4:
                return "Accessories";
            case 5:
                return "Gear";
            default:
                return null;
        }
   }


    
   public static void addToCart(Products product) {
        products.add(product);
    }
    
    
   public void browseShop(User_profile u){
      Scanner scanner = new Scanner(System.in);
        
         
      while (active) {
        String category = chooseCategory();
        ArrayList<Products> products = Main_Menu.products;
        if (category == null) {
                System.out.println("Exiting shop...");
                active = false;
                break;
        }
        showProducts(category,products);
    
        System.out.print("Enter the number of the product you want to choose (0 to exit): ");
            int choice = scanner.nextInt();

        if (choice >= 1 && choice <= products.size()) {
           Products chosenProduct = products.get(choice - 1);
           addToCart(chosenProduct);
                
           System.out.print("Product added to cart. Do you want to proceed to checkout? (Y/N): ");
           String checkoutChoice = scanner.next();
           if (checkoutChoice.equalsIgnoreCase("Y")) {
                checkoutProcess(u);
                break;
           }
           else if (choice == 0) {
                active = false;
                System.out.println("Exiting shop...");
                
           } 
           else {
                System.out.println("Invalid product choice!");
           }
       }
   }  
  }

   public void checkoutProcess(User_profile u) {
        

        Checkout checkout = new Checkout(products);
        double totalAmount=checkout.calculateTotal(products);
        //edw prepei na elegxoume pws tha ginei h syndesh me ta discounts
        checkout.calculateTotalWithDiscount(u.getProfileDiscount());
        giveAddress(checkout);
        totalAmount=checkout.calculateTotalWithTravelCosts(2.99);
        
        Payment payment = new Payment(totalAmount);
        
        String chosenPaymentMethod = choosePaymentMethod();
        
        if (chosenPaymentMethod.equalsIgnoreCase("card")) {
            provideCardDetails(payment);
            payment.makePayment(checkout.getTotalAmount());
        } else {
            checkout.calculateTotalWithCOD(3.49);
        }

        if (!confirmPayment(payment)) {
            active = true;
        } else {
            System.out.println("Your shopping has ended");
        }
    }
 
    
   private String choosePaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a payment method:");
        System.out.println("1. Card Payment");
        System.out.println("2. Cash on Delivery (COD)");
        System.out.print("Enter the number of the payment method: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "Card";
            case 2:
                return "COD";
            default:
                System.out.println("Invalid payment method choice!");
                return choosePaymentMethod();
        }
   }
    
   private void provideCardDetails(Payment payment) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();
        payment.cardNumber = cardNumber;
    
        System.out.print("Enter expiration date (MM/YY): ");
        String expirationDate = scanner.nextLine();
        payment.expirationDate = expirationDate;
    
        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();
        payment.cvv = cvv;
    
        System.out.println("Card details added successfully.");
   }
    
   private boolean confirmPayment(Payment payment) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please confirm your payment (Y/N): ");
        String confirmation = scanner.next();
        return confirmation.equalsIgnoreCase("Y");
   }
    
   private void giveAddress(Checkout checkout) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        checkout.setAddress(address);
   }
}