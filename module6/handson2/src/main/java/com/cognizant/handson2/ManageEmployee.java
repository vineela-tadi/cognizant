package com.cognizant.handson2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

    public static void main(String[] args) {

        // SessionFactory create
        SessionFactory factory =
                new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Session open
        Session session = factory.openSession();

        // ---------------- SAVE ----------------
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee(1, "Ganesh", "Tadi", 50000);

        session.save(emp);

        tx.commit();

        System.out.println("Employee Saved Successfully");

        // ---------------- LIST ----------------
        List<Employee> employees = session.createQuery("from Employee").list();

        for (Employee e : employees) {
            System.out.println(
                    e.getId() + " "
                    + e.getFirstName() + " "
                    + e.getLastName() + " "
                    + e.getSalary());
        }

        // ---------------- GET ----------------
        Employee employee = session.get(Employee.class, 1);

        if (employee != null) {
            System.out.println("Fetched : " + employee.getFirstName());
        }

        // ---------------- DELETE ----------------
        Transaction tx2 = session.beginTransaction();

        session.delete(employee);

        tx2.commit();

        System.out.println("Employee Deleted");

        session.close();
        factory.close();
    }
}