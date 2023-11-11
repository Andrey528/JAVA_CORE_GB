package hw.hw5.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private List<Double> grades;
    private String speciality;

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                ", speciality='" + speciality + '\'' +
                ", average grade=" + getAverageGrade() +
                '}';
    }
}
