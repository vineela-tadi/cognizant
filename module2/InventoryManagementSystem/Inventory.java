import java.util.HashMap;

class Inventory {

    HashMap<Integer, Product> map = new HashMap<>();

    // Add Product
    public void addProduct(Product p) {
        map.put(p.productId, p);
        System.out.println("✅ Product Added");
    }

    // Update Product
    public void updateProduct(int id, int quantity, double price) {
        if (map.containsKey(id)) {
            Product p = map.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("✅ Product Updated");
        } else {
            System.out.println("❌ Product Not Found");
        }
    }

    // Delete Product
    public void deleteProduct(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            System.out.println("✅ Product Deleted");
        } else {
            System.out.println("❌ Product Not Found");
        }
    }

    // Display All Products
    public void displayAll() {
        System.out.println("\n📦 Inventory List:");
        for (Product p : map.values()) {
            p.display();
        }
    }
}