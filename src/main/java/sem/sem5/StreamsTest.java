package sem.sem5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import hw.hw3.models.Employee;

public class StreamsTest {
    public static void main(String[] args) {
        testStringsCollection();
        testIntegerCollection();
    }


    /**
     * Отфильтровать и оставить только четные числа.
     * Преобразовать каждое число в его квадрат.
     * Пропустить первые два элемента потока.
     * Ограничить количество элементов в потоке до 4.
     * Отсортировать оставшиеся элементы в порядке убывания.
     * Преобразовать каждое число в строку с префиксом "Number: ".
     */

    //конвеерные и терминальные
    public static void testIntegerCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18);
        List<String> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .skip(2)
                .limit(4)
                .map(n -> n * n)
//                .sorted(Comparator.reverseOrder())
                .sorted((a, b) -> b - a)
                .map(n -> "Number: " + n)
                .collect(Collectors.toList());

//        System.out.println(result);
    }

    /**
     * Отфильтровать и оставить только те строки, которые начинаются на букву "J".
     * Избавиться от повторений.
     * Преобразовать все строки к верхнему регистру.
     * Пропустить первую строку.
     * Ограничить количество строк в потоке до 2.
     * Отсортировать строки в алфавитном порядке.
     * Добавить к каждой строке "!".
     */
    public static void testStringsCollection() {
        List<String> strings = Arrays.asList("Java", "Java", "Python", "JavaScript", "C++", "Java", "JavaFX");

        var result = strings.stream()
                .filter(s -> s.startsWith("J"))
                .distinct()
//                .map(s -> s.toUpperCase())
                .map(String::toUpperCase)
//                .forEach(System.out::println)
                .skip(1)
                .limit(2)
                .sorted()
                .map(s -> s + "!")
                .map(s -> Employee.builder()
                        .name(s)
                        .age(new Random().nextInt(33))
                        .salary(new Random().nextInt(33000))
                        .build()
                )/*.map(s -> {
                    Person person = new Person();
                    person.setName(s);
                    person.setAge(new Random().nextInt(33));
                    person.setSalary(new Random().nextInt(33000));
                    return person;
                })*/
//                .collect(Collectors.toList());
                .toList();

        var maxSalary = result.stream()
                .map(Employee::getSalary)
                .max(Comparator.naturalOrder());

        System.out.println(result);
        System.out.println(maxSalary);
    }
}
