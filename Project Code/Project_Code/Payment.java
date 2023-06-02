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
     
    
    public void makePayment(double amount) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Total amount: " + amount);
    System.out.print("Enter payment amount: ");
    double paymentAmount = scanner.nextDouble();
    
    if (paymentAmount >= amount) {
        System.out.println("Payment successful. Thank you!");
        createOrder();
    } else {
        System.out.println("Insufficient payment amount. Please try again.");
        makePayment(amount); 
    }
}
    
    private void createOrder() {
     LocalDateTime orderDate = LocalDateTime.now();
    String status = "Processing";
    
    Order order = new Order(orderDate, status);
    
    order.setStatus("Processing");
}

    
}
