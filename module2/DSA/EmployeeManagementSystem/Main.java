public class Main {
    public static void main(String[] args) {

        EmployeeManagement em = new EmployeeManagement(5);

        em.addEmployee(new Employee(101, "Ravi", "Manager", 50000));
        em.addEmployee(new Employee(102, "Sita", "Developer", 40000));
        em.addEmployee(new Employee(103, "Ram", "Tester", 30000));

        System.out.println("All Employees:");
        em.displayEmployees();

        System.out.println("\nSearch Employee:");
        em.searchEmployee(102);

        System.out.println("\nDelete Employee:");
        em.deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        em.displayEmployees();
    }
}