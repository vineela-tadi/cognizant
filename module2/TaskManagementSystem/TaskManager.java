class TaskManager {
    Task head = null;

    // Add Task
    void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    // Traverse
    void displayTasks() {
        Task temp = head;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    // Search
    void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task Found:");
                temp.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task Not Found");
    }

    // Delete
    void deleteTask(int id) {
        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted");
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted");
        }
    }
}