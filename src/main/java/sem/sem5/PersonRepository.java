package sem.sem5;

import hw.hw3.models.Employee;

import java.util.Optional;

public class PersonRepository {
    public Optional<Employee> findById(String id) {
        if (id.equals("id")) {
            return Optional.of(new Employee("Timofei", 99, 100));
        }
        return Optional.empty();
    }
}
