package module1.ProxyPatternExample;
public class Main {
    public static void main(String[] args) {

        Image image = new ProxyImage("photo1.jpg");

        // First time → loads from server
        image.display();

        System.out.println("-------------");

        // Second time → uses cache (no loading)
        image.display();
    }
}