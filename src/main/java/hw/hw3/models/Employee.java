package hw.hw3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Employee {
    private String name;
    private int age;
    private int salary;
    private LocalDate hireDate;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static int compareHireDates(Employee employee1, Employee employee2) {
        LocalDate localDate1 = employee1.getHireDate();
        LocalDate localDate2 = employee2.getHireDate();

        int date1 = (localDate1.getYear() << 9) | (localDate1.getMonthValue() << 5) | localDate1.getDayOfMonth();
        int date2 = (localDate2.getYear() << 9) | (localDate2.getMonthValue() << 5) | localDate2.getDayOfMonth();

        return Integer.compare(date1, date2);
    }
}
