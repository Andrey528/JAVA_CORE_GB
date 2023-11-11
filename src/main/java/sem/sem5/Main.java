package sem.sem5;

import hw.hw3.models.Employee;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        var personRepository = new PersonRepository();
        Optional<Employee> personOptional = personRepository.findById("id1");
        if (personOptional.isPresent()) {
            Employee person = personOptional.get();
            System.out.println(person);
        }

        personOptional.ifPresent(person -> System.out.println(person));

        Employee defaultPerson = new Employee();
        Employee person = personRepository.findById("id1").orElse(defaultPerson);
//        System.out.println(person);

        Employee person1 = personRepository.findById("id1")
                .orElseGet(() -> Employee.builder()
                        .name("Default")
                        .salary(100000)
                        .age(12)
                        .build());
        System.out.println(person1);

        String id = "id";
        String name = personRepository.findById(id)
                .map(Employee::getName)
                .orElseThrow(() -> new NoEmployeeException(id));

        System.out.println(name);
    }
}
