public class Main {
    public static void main(String[] args) {

        // Basic Email Notification
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello!");

        System.out.println("\n--- With SMS ---");
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        smsNotifier.send("Hello!");

        System.out.println("\n--- With SMS + Slack ---");
        Notifier fullNotifier = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()
                                    )
                                );
        fullNotifier.send("Hello!");
    }
}