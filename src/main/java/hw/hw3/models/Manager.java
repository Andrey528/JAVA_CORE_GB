package hw.hw3.models;


import hw.hw3.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

public class Manager extends Employee {
    public Manager(String name, int age, int salary, LocalDate hireDate) {
        super(name, age, salary, hireDate);
    }

    public static void increaseSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.setSalary((int)(employee.getSalary() + employee.getSalary() * (percentage / 100)));
            }
        }
    }
}
