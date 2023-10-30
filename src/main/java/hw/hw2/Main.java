package hw.hw2;

import java.util.Arrays;
import java.util.Random;

/***
 * Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
 * Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.
 * Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = genArray(10);
        System.out.println(Arrays.toString(arr));
        System.out.printf("Count of even: %d\n", countEvenEl(arr));
        System.out.printf("Diff between max and min: %d\n", maxMinDiff(arr));
        System.out.printf("Check 2 zero value near: %b", nullCheck(arr));
    }

    static int[] genArray(int length) {
        Random random = new Random();
        int [] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(0, 5);
        }
        return arr;
    }

    static int countEvenEl(int[] arr) {
        int count = 0;

        for (int item: arr) {
            if (item % 2 == 0)
                count++;
        }

        return count;
    }

    static int maxMinDiff(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
            if (min > arr[i])
                min = arr[i];
        }

        return max - min;
    }

    static boolean nullCheck(int[] arr) {
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (prev == 0 && arr[i] == 0)
                return true;
            prev = arr[i];
        }

        return false;
    }
}
