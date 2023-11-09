package hw.hw3;

import hw.hw3.models.Employee;
import hw.hw3.models.Manager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Manager("John", 32, 5000, LocalDate.of(2001, 1, 17));
        employees[1] = new Employee("Mary", 32, 3000, LocalDate.of(2006, 4, 1));
        employees[2] = new Employee("David", 32, 2500, LocalDate.of(2008, 1, 11));
        employees[3] = new Employee("Sarah", 32, 3500, LocalDate.of(2008, 12, 14));

        System.out.printf("Employee1 is " + employees[2] + "\n");
        System.out.printf("Employee2 is " + employees[3] + "\n");

        System.out.println(Employee.compareHireDates(employees[2], employees[3]));

        System.out.println(employees[0]);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
