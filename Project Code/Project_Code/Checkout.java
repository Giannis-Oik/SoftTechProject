import java.util.ArrayList;
public class Checkout extends Shop {
    private ArrayList<Product> products;
    private double totalAmount;
    String address;

    public Checkout() {
        products = new ArrayList<>();
        totalAmount = 0.0;
        
    }

    public double calculateTotal(ArrayList<Product> products) {
        this.products = products;
        totalAmount = 0.0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    public double calculateTotalWithTravelCosts(ArrayList<Product> products) {
        //
        return totalAmount;
    }

    public double calculateTotalWithCOD(ArrayList<Product> products, int cod) {
        //
        return totalAmount;
    }
    
    
    public double calculateTotalWithDiscount(ArrayList<Product> products) {
        //
        return totalAmount;
    }

    

    public double getTotalAmount() {
        return totalAmount;
    }

   public void setAddress(String address) {
        this.address = address;
    }

   
}
