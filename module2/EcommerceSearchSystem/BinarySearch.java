public class BinarySearch {

    public static Product search(Product[] products, String name) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = name.compareToIgnoreCase(products[mid].productName);

            if (result == 0)
                return products[mid];
            else if (result > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}