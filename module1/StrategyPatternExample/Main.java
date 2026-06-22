public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Credit Card payment
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012"));
        context.payAmount(5000);

        // PayPal payment
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.payAmount(2500);
    }
}