import java.util.ArrayList;
public class Checkout extends Shop {
    
    double totalAmount;
    String address;

    public Checkout(ArrayList<Products> products) {
    this.products = products;
    this.totalAmount = 0.0;
}


    public double calculateTotal(ArrayList<Products> products) {
             for (Products product : products) {
            totalAmount += product.getPrice();
        }
        System.out.println("Total amount calculated: €" + totalAmount);
        return totalAmount;
    }

    
    public double calculateTotalWithTravelCosts(double travelCosts) {
        totalAmount += travelCosts;
        System.out.println("Added travel costs: €" + travelCosts);
        System.out.println("Updated total amount: €" + totalAmount);
        return totalAmount;
    }

    
        
    public double calculateTotalWithCOD(double cod) {
        totalAmount += cod;
        System.out.println("Added COD amount: €" + cod);
        System.out.println("Updated total amount: €" + totalAmount);
        return totalAmount;
    }


    
        
    public double calculateTotalWithDiscount(double discountPercentage) {
        double discountAmount = (discountPercentage / 100) * totalAmount;
        totalAmount -= discountAmount;
        System.out.println("Applied discount of " + discountPercentage + "%: €" + discountAmount);
        System.out.println("Updated total amount: €" + totalAmount);
        return totalAmount;
    }

 public void setAddress(String address) {
        this.address = address;
    }

 public String getAddress() {
        return address;
    }



    

    public double getTotalAmount() {
        return totalAmount;
    }


   
}
