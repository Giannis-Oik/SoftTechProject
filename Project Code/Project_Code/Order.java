import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order  {
    private static int nextOrderID = 1;
    private int orderID;
    private LocalDateTime orderDate;
    private String dateOfArrival;
    private String status;
    private ArrayList<Products> orderedProducts;

    public Order(ArrayList<Products> orderedProducts,LocalDateTime orderDate, String status) {
        this.orderID = nextOrderID++;
        this.orderDate = LocalDateTime.now();
        this.dateOfArrival = "";
        this.status = "Processing";
        this.orderedProducts = orderedProducts;
    }

    public int getOrderID() {
        return orderID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Products> getOrderedProducts() {
        return orderedProducts;
    }

    public void addProductToOrder(Products product) {
        orderedProducts.add(product);
    }

    
    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }
    
    public boolean hasSufficientStock(ArrayList<Products> availableProducts) {
        for (Products orderedProduct : orderedProducts) {
            for (Products availableProduct : availableProducts) {
                if (orderedProduct.getName().equals(availableProduct.getName())) {
                    if (orderedProduct.getQuantity() > availableProduct.getQuantity()) {
                        System.out.println("Insufficient stock for product: " + orderedProduct.getName());
                        return false;
                    }
                    break; // Found matching product, no need to check remaining available products
                }
            }
        }
        return true; // All products have sufficient stock
    }

    public void updateProductQuantities(ArrayList<Products> availableProducts) {
        for (Products orderedProduct : orderedProducts) {
            for (Products availableProduct : availableProducts) {
                if (orderedProduct.getName().equals(availableProduct.getName())) {
                    int updatedQuantity = availableProduct.getQuantity() - orderedProduct.getQuantity();
                    availableProduct.setQuantity(updatedQuantity);
                    break; // Found matching product, no need to check remaining available products
                }
            }
        }
    }
}
