import java.util.ArrayList;
import java.util.Scanner;
public class Shop{
boolean active;
boolean checkout;
ArrayList<Product> products;

 public Shop() {
        active = true;
        checkout = false;
        products = new ArrayList<>();
        initializeProducts();
    }
    
    public void initializeProducts() {
    products = new ArrayList<>();

    // Supplements
        products.add(new Product("Protein Powder 1", 29.99, "Supplements"));
        products.add(new Product("Protein Powder 2", 39.99, "Supplements"));
        products.add(new Product("Pre-Workout 1", 29.99, "Supplements"));
        products.add(new Product("Pre-Workout 2", 39.99, "Supplements"));
        products.add(new Product("Magnesium", 19.99, "Supplements"));

        // Clothes
        products.add(new Product("T-Shirt", 19.99, "Clothes"));
        products.add(new Product("Shorts", 24.99, "Clothes"));
        products.add(new Product("Leggings", 29.99, "Clothes"));
        products.add(new Product("Hoodie", 39.99, "Clothes"));
        products.add(new Product("Jacket", 49.99, "Clothes"));

        // Shoes
        products.add(new Product("Running Shoes", 79.99, "Shoes"));
        products.add(new Product("Training Shoes", 89.99, "Shoes"));
        products.add(new Product("Basketball Shoes", 99.99, "Shoes"));
        products.add(new Product("Sneakers", 69.99, "Shoes"));
        products.add(new Product("Sandals", 39.99, "Shoes"));

        // Accessories
        products.add(new Product("Gym Bag", 39.99, "Accessories"));
        products.add(new Product("Water Bottle", 9.99, "Accessories"));
        products.add(new Product("Yoga Mat", 19.99, "Accessories"));
        products.add(new Product("Resistance Bands", 14.99, "Accessories"));
        products.add(new Product("Gloves", 14.99, "Accessories"));

        // Gear
        products.add(new Product("Dumbbells", 49.99, "Gear"));
        products.add(new Product("Jump Rope", 9.99, "Gear"));
        products.add(new Product("Exercise Ball", 29.99, "Gear"));
        products.add(new Product("Foam Roller", 19.99, "Gear"));
        products.add(new Product("Weight Bench", 149.99, "Gear"));
    }
    




    
    
    

 private void showProducts(String category) {
    System.out.println("Available products in the " + category + " category:");
    for (int i = 0; i < products.size(); i++) {
        Product product = products.get(i);
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


    
    public void addToCart(Product product) {
        products.add(product);
    }
    
    
    public void browseShop(){
        Scanner scanner = new Scanner(System.in);
        
         
     while (active) {
    String category = chooseCategory();
            if (category == null) {
                System.out.println("Exiting shop...");
                active = false;
                break;
            }
            showProducts(category);
    
     System.out.print("Enter the number of the product you want to choose (0 to exit): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= products.size()) {
                Product chosenProduct = products.get(choice - 1);
                addToCart(chosenProduct);
                
                 System.out.print("Product added to cart. Do you want to proceed to checkout? (Y/N): ");
            String checkoutChoice = scanner.next();
            if (checkoutChoice.equalsIgnoreCase("Y")) {
                checkoutProcess();
                break;
            }
            } else if (choice == 0) {
                active = false;
                System.out.println("Exiting shop...");
                
            } else {
                System.out.println("Invalid product choice!");
            }
}
}

private void checkoutProcess() {
        checkout = true;

        Checkout checkout = new Checkout();
        double totalAmount=checkout.calculateTotal(products);
        giveAddress(checkout);
        totalAmount=checkout.calculateTotalWithTravelCosts(2.99); 
        //edw prepei na elegxoume pws tha ginei h syndesh me ta discounts
        //checkout.calculateTotalWithDiscount(discount);
        
        Payment payment = new Payment(totalAmount);
        payment.makePayment(checkout.getTotalAmount());
        String chosenPaymentMethod = choosePaymentMethod();
        
        if (chosenPaymentMethod.equalsIgnoreCase("card")) {
            provideCardDetails(payment);
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