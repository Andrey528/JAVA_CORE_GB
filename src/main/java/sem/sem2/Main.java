package sem.sem2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Задача: Задать одномерный массив. Написать методы поиска в нём
        //минимального и максимального элемента;
        int[] arr = genArray(10);
        System.out.println(Arrays.toString(arr));
        System.out.printf("Max value: %d\n", findMaxValue(arr));
        System.out.printf("Min value: %d\n", findMinValue(arr));
        System.out.printf("Max value index: %d\n", findMaxIndex(arr));
        System.out.printf("Min value index: %d\n", findMinIndex(arr));

        //Задача: Создать квадратный целочисленный массив (количество строк и
        //столбцов одинаковое), заполнить его диагональные элементы единицами,
        //используя цикл(ы)
        printSquareMatrix(genSquareMatrix(5));

//        Задача: Написать метод, в который передается не пустой одномерный
//        целочисленный массив, метод должен вернуть true если в массиве есть
//        место, в котором сумма левой и правой части массива равны. Примеры:
//        checkBalance([1, 1, 1, || 2, 1]) → true,
//                checkBalance([2, 1, 1, 2, 1]) → false,
//                checkBalance([10, || 1, 2, 3, 4]) → true.
//                Абстрактная граница показана символами ||, эти символы в массив не
//        входят.
        int[] arr1 = genArray(5);
        System.out.println(Arrays.toString(arr1));
        System.out.printf("Check equals left and right sum: %b\n", checkSumOfElArr(arr1));

//        Задача: Написать функцию добавления элемента в конец массива таким
//        образом, чтобы она расширяла массив при необходимости.
        System.out.println(Arrays.toString(addItemToArray(arr1, 7)));

//        Написать структуру данных, хранящую целые числа и поддерживающую следующие операции:
//        добавление значения в множество
//        проверка, есть ли значение в множестве
//        удаление значения из множества
//        получение равномерного случайного значения из множества.
//        все операции O(1)
        RandomSet randomSet = new RandomSet(new HashSet<>(Arrays.asList(1, 5 ,10)));
        randomSet.add(6);
        System.out.println(randomSet.hashSet.toString());
        randomSet.add(5);
        System.out.println(randomSet.hashSet.toString());
        System.out.println(randomSet.contains(5));
        System.out.println(randomSet.remove(5));
        System.out.println(randomSet.contains(5));
        System.out.println(randomSet.getRandom());
    }

    static int[] genArray(int length) {
        Random random = new Random();
        int [] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(1, 15);
        }
        return arr;
    }

    static int findMaxValue(int[] arr) {
        int max = arr[0];

        for (int item : arr) {
            if (item > max)
                max = item;
        }

        return max;
    }

    static int findMinValue(int[] arr) {
        int min = arr[0];

        for (int item : arr) {
            if (item < min)
                min = item;
        }

        return min;
    }

    static int findMaxIndex(int[] arr) {
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i])
                max = i;
        }

        return max;
    }

    static int findMinIndex(int[] arr) {
        int min = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[min] > arr[i])
                min = i;
        }

        return min;
    }

    static int[][] genSquareMatrix(int length) {
        int[][] arr = new int[length][length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            arr[i][i] = 1;
            arr[i][length - 1 - i] = 1;
        }

        return arr;
    }

    static void printSquareMatrix(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkSumOfElArr(int[] arr) {
        int len = arr.length;
        int sum = 0;

        for (int j : arr) {
            sum += j;
        }

        if (sum % 2 != 0)
            return false;

        int leftSum = 0;

        for (int j : arr) {
            leftSum += j;
            sum -= j;
            if (leftSum == sum)
                return true;
        }

        return false;
    }

    static int[] addItemToArray(int[] arr, int newArrItem) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = newArrItem;
        return newArr;
    }

    static class RandomSet {
        HashSet<Integer> hashSet;

        public RandomSet(HashSet<Integer> hashSet) {
            this.hashSet = hashSet;
        }

        public boolean add(int val) {
            int lenBeforeAdd = hashSet.size();

            hashSet.add(val);

            return lenBeforeAdd != hashSet.size();
        }

        public boolean contains(int val) {
            return !add(val);
        }

        public int getRandom() {
            Integer[] arr = hashSet.toArray(new Integer[0]);
            Random random = new Random();
            return arr[random.nextInt(hashSet.size())];
        }

        public boolean remove(int val) {
            if (contains(val)) {
                hashSet.remove(val);
                return true;
            }
            else return false;
        }

        @Override
        public String toString() {
            return "RandomSet{" +
                    "hashSet=" + hashSet +
                    '}';
        }
    }
}
