import java.util.*;

public class Products {
    private String name;
    private double price;
    private String category;
    private int quantity;
    public Products(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
   
    public String getCategory() {
        return category;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    
    public static void checkStock(ArrayList<Products> products) {
       System.out.println("Current stock:");
       for (int i = 0; i < products.size(); i++) {
         Products product = products.get(i);
         System.out.println("ID: " + (i + 1));
         System.out.println("Name: " + product.getName());
         System.out.println("Price: " + product.getPrice());
         System.out.println("Category: " + product.getCategory());
         System.out.println("Quantity: " + product.getQuantity());
         System.out.println();
       }
    }
    
    public static void changeThings(Scanner scanner, Scanner scanner2,ArrayList<Products> products) {
         while (true) {
           
            System.out.println("----- Change Products -----");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Update product");
            System.out.println("4. Go back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    addProduct(scanner, scanner2,products);
                    break;
                case 2:
                    deleteProduct(scanner,products);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    public static void addProduct(Scanner scanner, Scanner scanner2,ArrayList<Products> products){
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the product category (Supplements, Clothes, Shoes, Accessories, Gear) : ");
        String category = scanner2.nextLine();
        System.out.print("Enter the product's quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        boolean productExists = false;
        for (int i = 0; i < products.size(); i++) {
           Products product = products.get(i);
           if(product.getName().equals(name)){
               int newQuantity;
               newQuantity = product.getQuantity() + quantity;
               product.setQuantity(newQuantity);
               productExists = true;
               break;
           }
        }
        if(!productExists){
             products.add(new Products(name,price,category,quantity));
        }
    }

    public static void deleteProduct(Scanner scanner, ArrayList<Products> products) {
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        boolean productFound = false;
        for(int i = 0; i < products.size(); i++){
            Products product = products.get(i);
            if(product.getName().equals(name)){
                products.remove(product);
                System.out.println("Product deleted successfully.");
                productFound = true;
                break;
            } 
        }  
        if(!productFound){
            System.out.println("Product not found in stock.");
        }
    }
     
    
    public static void openPricingPage(Scanner scanner,ArrayList<Products> products) {
       System.out.println("Current products and prices:");
       System.out.println("----------------------------");
        for(int i = 0; i < products.size(); i++){
           Products product = products.get(i);
           System.out.printf("%-20s $%.2f\n", product.getName(), product.getPrice());
       }

       System.out.print("Do you want to make changes? (Y/N): ");
       String choice = scanner.nextLine();

       if (choice.equalsIgnoreCase("Y")) {
            makeChanges(scanner,products);
       }
    }

    public static void makeChanges(Scanner scanner,ArrayList<Products> products) {
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        boolean productFound = false;
        for(int i = 0; i < products.size(); i++){
            Products product = products.get(i);
            if(product.getName().equals(name)){
                System.out.print("Enter the new price: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); 
                
                product.setPrice(price);
                System.out.println("Price changed successfully.");
                productFound = true;
                break;
            }
        }
        if(!productFound){
            System.out.println("Product not found in stock.");
        }
    }
}