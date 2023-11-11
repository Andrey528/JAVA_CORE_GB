package hw.hw5;

import hw.hw5.controllers.StudentController;
import hw.hw5.models.Student;
import hw.hw5.models.StudentRepo;
import hw.hw5.presenters.ConsoleView;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentRepo students = new StudentRepo();
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("Alice", Arrays.asList(4.0, 3.0, 5.0, 4.0), "Математика"));
        students.addStudent(new Student("Bob", Arrays.asList(5.0, 5.0, 5.0, 5.0), "Информатика"));
        students.addStudent(new Student("Bob", Arrays.asList(5.0, 5.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("Bob", Arrays.asList(4.0, 5.0, 5.0, 5.0), "Информатика"));
        students.addStudent(new Student("Emily", Arrays.asList(5.0, 4.0, 5.0, 4.0), "Информатика"));
        students.addStudent(new Student("David", Arrays.asList(3.0, 3.0, 4.0, 4.0), "Физика"));
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));
        students.addStudent(new Student("John", Arrays.asList(5.0, 4.0, 4.0, 5.0), "Информатика"));

        ConsoleView view = new ConsoleView();

        StudentController studentController = new StudentController(students, view);

        studentController.buttonClick();
    }
}
