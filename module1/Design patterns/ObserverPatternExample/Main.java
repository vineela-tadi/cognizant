public class Main {
    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobile1 = new MobileApp("User1");
        Observer web1 = new WebApp("User2");

        // Register observers
        stockMarket.registerObserver(mobile1);
        stockMarket.registerObserver(web1);

        // Change stock price
        stockMarket.setStockPrice(100.50);

        System.out.println("-------------");

        // Remove one observer
        stockMarket.removeObserver(mobile1);

        // Change stock price again
        stockMarket.setStockPrice(120.75);
    }
}