package hw.hw5.controllers;

import hw.hw5.models.Student;
import hw.hw5.models.StudentRepo;
import hw.hw5.presenters.ConsoleView;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class StudentController {
    private StudentRepo students;
    private ConsoleView consoleView;

    public void buttonClick() {
        consoleView.printStudents(students.studentFilter());
    }
}
