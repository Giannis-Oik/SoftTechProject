import java.util.ArrayList;
public class Checkout extends Shop {
    private ArrayList<Products> products;
    private double totalAmount;
    String address;

    public Checkout() {
        products = new ArrayList<>();
        totalAmount = 0.0;
        
    }

    public double calculateTotal(ArrayList<Products> products) {
        this.products = products;
        totalAmount = 0.0;
        for (Products product : products) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

    public double calculateTotalWithTravelCosts(ArrayList<Products> products) {
        //
        return totalAmount;
    }

    public double calculateTotalWithCOD(ArrayList<Products> products, int cod) {
        //
        return totalAmount;
    }
    
    
    public double calculateTotalWithDiscount(ArrayList<Products> products) {
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
