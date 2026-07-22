public class SingletonTest {

    public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("Hello");
        l2.log("Welcome");

        System.out.println(l1);
        System.out.println(l2);
    }
}