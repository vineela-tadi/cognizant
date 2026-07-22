public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(String id) {
        // Simulated database lookup
        if (id.equals("101")) {
            return "John Doe";
        } else if (id.equals("102")) {
            return "Alice Smith";
        }
        return "Customer Not Found";
    }
}