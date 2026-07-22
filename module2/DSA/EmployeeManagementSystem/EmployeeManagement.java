class EmployeeManagement {
    Employee[] employees;
    int count;

    EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add Employee
    void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
        } else {
            System.out.println("Array is Full!");
        }
    }

    // Traverse Employees
    void displayEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Search Employee
    void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found:");
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    // Delete Employee
    void deleteEmployee(int id) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted");
    }
}