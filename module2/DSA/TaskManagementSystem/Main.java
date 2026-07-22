public class Main {
    public static void main(String[] args) {

        TaskManager tm = new TaskManager();

        tm.addTask(1, "Design UI", "Pending");
        tm.addTask(2, "Develop Backend", "In Progress");
        tm.addTask(3, "Testing", "Pending");

        System.out.println("All Tasks:");
        tm.displayTasks();

        System.out.println("\nSearch Task:");
        tm.searchTask(2);

        System.out.println("\nDelete Task:");
        tm.deleteTask(2);

        System.out.println("\nAfter Deletion:");
        tm.displayTasks();
    }
}