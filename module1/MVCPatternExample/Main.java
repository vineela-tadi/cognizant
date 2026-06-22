public class Main {
    public static void main(String[] args) {

        // Create Model
        Student student = new Student();
        student.setName("John");
        student.setId("101");
        student.setGrade("A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        // Update data using controller
        controller.setStudentName("Alice");
        controller.setStudentGrade("A+");

        System.out.println("\nAfter Update:\n");

        // Display updated data
        controller.updateView();
    }
}