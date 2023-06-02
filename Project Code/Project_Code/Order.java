import java.time.LocalDateTime;

public class Order   {
    private static int nextOrderID = 1;
    private String dateOfArrival;
    private int orderID;
    private LocalDateTime orderDate;
    private String status;
    
    public Order(LocalDateTime orderDate, String status) {
        this.orderID = nextOrderID++;
        this.orderDate = orderDate;
        this.status = status;
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
    
    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }
}
