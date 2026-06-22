class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    // Constructor
    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Display Method
    public void display() {
        System.out.println(productId + " | " + productName + " | Qty: " + quantity + " | Price: " + price);
    }
}