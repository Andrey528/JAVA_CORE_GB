package hw.hw5.presenters;

import hw.hw5.models.Student;

import java.util.List;

public class ConsoleView {
    public void printStudents(List<Student> students) {
        students.forEach(student -> System.out.println(student.toString()));
    }
}
