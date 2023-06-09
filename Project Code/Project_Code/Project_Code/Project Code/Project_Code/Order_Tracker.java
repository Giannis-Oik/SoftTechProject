import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
class Order_Tracker extends EShop_Menu {
    private ArrayList<Order> orderList;

    public Order_Tracker(ArrayList<Order> orderList) {
        
        this.orderList = orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void showOrderList() {
        System.out.println("Available orders:");
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            System.out.println((i + 1) + ". Order ID: " + order.getOrderID() +
                    " - Status: " + order.getStatus());
        }
    }

    public boolean isOrderListEmpty() {
        return orderList.isEmpty();
    }

    public Order getSelectedOrder(int selectedIndex) {
        if (selectedIndex >= 0 && selectedIndex < orderList.size()) {
            return orderList.get(selectedIndex);
        } else {
            return null;
        }
    }

    public boolean askUserForDetails() {
        System.out.print("Do you want to view order details? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }

    public void returnOrderDetails(Order order) {
    System.out.println("Order details for Order ID: " + order.getOrderID());
    System.out.println("Order Date: " + order.getOrderDate());
    
    System.out.println("Status: " + order.getStatus());
    
}

    public  void calculateDateOfArrival(Order order) {
    LocalDateTime orderDate = order.getOrderDate();
    LocalDateTime dateOfArrival = orderDate.plusDays(5); 

    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDateOfArrival = dateOfArrival.format(formatter);

    order.setDateOfArrival(formattedDateOfArrival); 
}

    public void returnDateOfArrival(Order order) {
    System.out.println("Estimated date of arrival: " + order.getDateOfArrival());
}

    public boolean askUserForBrowsing() {
        System.out.print("Do you want to browse other orders? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }

    public void track_ordering() {
        Scanner scanner = new Scanner(System.in);
        int order_track = 1;

        while (order_track == 1) {
            showOrderList();

            if (isOrderListEmpty()) {
                System.out.println("List is empty.");
                break;
            }

            System.out.print("Enter the number of the order you want to track (0 to exit): ");
            int selectedOrderNumber = scanner.nextInt();
            scanner.nextLine(); 

            if (selectedOrderNumber == 0) {
                break;
            }

            int selectedIndex = selectedOrderNumber - 1;
            Order selectedOrder = getSelectedOrder(selectedIndex);

            if (selectedOrder != null) {
                System.out.println("Selected order: Order ID: " + selectedOrder.getOrderID() +
                        " - Status: " + selectedOrder.getStatus());

                boolean viewOrderDetails = askUserForDetails();

                if (viewOrderDetails) {
                    returnOrderDetails(selectedOrder);
                }

                calculateDateOfArrival(selectedOrder);
                returnDateOfArrival(selectedOrder);

                boolean browseOtherOrders = askUserForBrowsing();

                if (!browseOtherOrders) {
                    break;
                }
            } else {
                System.out.println("Invalid order number.");
            }
        }
    }
}
