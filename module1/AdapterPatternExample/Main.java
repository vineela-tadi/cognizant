package module1.AdapterPatternExample;
public class Main {
    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());

        paypal.processPayment(1000);
        stripe.processPayment(2000);
        razorpay.processPayment(3000);
    }
}