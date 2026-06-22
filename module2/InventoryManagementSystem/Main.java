public class Main {
    public static void main(String[] args) {

        Inventory inv = new Inventory();

        // Adding products
        Product p1 = new Product(1, "Laptop", 10, 50000);
        Product p2 = new Product(2, "Mouse", 50, 500);

        inv.addProduct(p1);
        inv.addProduct(p2);

        // Display
        inv.displayAll();

        // Update product
        inv.updateProduct(1, 15, 48000);

        // Delete product
        inv.deleteProduct(2);

        // Final display
        System.out.println("\nAfter Update & Delete:");
        inv.displayAll();
    }
}