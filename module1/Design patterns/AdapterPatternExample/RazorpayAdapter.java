package module1.AdapterPatternExample;
public class RazorpayAdapter implements PaymentProcessor {

    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void processPayment(double amount) {
        razorpay.payAmount(amount);
    }
}