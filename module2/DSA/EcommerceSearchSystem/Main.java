import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Mouse", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Watch", "Accessories")
        };

        // Linear Search
        Product res1 = LinearSearch.search(products, "Shoes");
        System.out.println("Linear Search: " + (res1 != null ? res1.productName : "Not Found"));

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        Product res2 = BinarySearch.search(products, "Shoes");
        System.out.println("Binary Search: " + (res2 != null ? res2.productName : "Not Found"));
    }
}