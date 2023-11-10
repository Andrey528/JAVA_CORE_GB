package sem.sem4;

import java.util.*;

/**
 * Имеются 2 вектора.
 * Требуется написать функцию, которая считает количество общих чисел между двумя векторами и
 * возвращает результат в виде вектора. В ответе необходимо исключить кратность при дубликации*/
public class Vectors {
    public static List<Integer> countCommonNumbers(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();
        int resultCount = 0;


        for (int i = 0; i < list1.size(); i++) {
            int num1 = list1.get(i);
            int num2 = list2.get(i);

            if (!set1.contains(num1)) {
                set1.add(num1);
                if (set2.contains(num1)) {
                    ++resultCount;
                }
            }

            if (!set2.contains(num2)) {
                set2.add(num2);
                if (set1.contains(num2)) {
                    ++resultCount;
                }
            }

            resultList.add(resultCount);
        }
        return resultList;

    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 0, 1, 3);

        List<Integer> result = countCommonNumbers(list1, list2);
        System.out.println(result); // Должно вывести [0, 1, 2, 3]

        list1 = Arrays.asList(1, 1, 2, 3);
        list2 = Arrays.asList(2, 1, 3, 1);

        result = countCommonNumbers(list1, list2);
        System.out.println(result); // Должно вывести [0, 1, 2, 3]
    }
}
