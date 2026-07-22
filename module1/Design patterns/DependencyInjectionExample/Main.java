public class Main {
    public static void main(String[] args) {

        // Inject dependency
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        // Use service
        service.getCustomer("101");
        service.getCustomer("102");
        service.getCustomer("999");
    }
}