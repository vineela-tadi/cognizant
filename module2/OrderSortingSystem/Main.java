public class Main {

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o.orderId + " - " + o.customerName + " - " + o.totalPrice);
        }
    }

    public static void main(String[] args) {

        Order[] orders = {
            new Order(1, "Alice", 2500),
            new Order(2, "Bob", 1500),
            new Order(3, "Charlie", 3000),
            new Order(4, "David", 1000)
        };

        System.out.println("Before Sorting:");
        printOrders(orders);

        // Bubble Sort
        BubbleSort.sort(orders);
        System.out.println("\nAfter Bubble Sort:");
        printOrders(orders);

        // Quick Sort
        QuickSort.sort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        printOrders(orders);
    }
}