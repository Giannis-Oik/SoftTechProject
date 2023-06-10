import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
public class Payment extends Shop {
    private double amount;
    private boolean isCardPayment;
    private boolean isCashPayment;
     String cardNumber;
     String expirationDate;
     String cvv;
    
     public Payment(double amount) {
        this.amount = amount;
        this.isCardPayment = false;
        this.isCashPayment = false;
        this.cardNumber = "";
        this.expirationDate = "";
        this.cvv = "";
        this.orderList=orderList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCardPayment() {
        return isCardPayment;
    }

    public void setCardPayment(boolean cardPayment) {
        isCardPayment = cardPayment;
    }

    public boolean isCashPayment() {
        return isCashPayment;
    }

    public void setCashPayment(boolean cashPayment) {
        isCashPayment = cashPayment;
    }
     
    

    
    public void createOrder() {
    LocalDateTime orderDate = LocalDateTime.now();
    String status = "Processing";
  
    Order order = new Order(products, orderDate, status);
  
    order.setStatus("Processing");
    order.updateProductQuantities(Shop.getAvailableProducts());
    orderList.add(order);
}
 
    
}
