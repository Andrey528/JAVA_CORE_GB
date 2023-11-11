package hw.hw5.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentRepo {
    private List<Student> students;

    public StudentRepo() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> studentFilter() {
        return students.stream()
                .filter(student -> student.getSpeciality().equals("Информатика"))
                .filter(student -> student.getAverageGrade() > 4.5)
                .limit(5)
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .toList();
    }
}
