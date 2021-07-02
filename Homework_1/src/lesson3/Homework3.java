package lesson3;

import java.util.Arrays;
import java.util.Random;

public class Homework3 {
    public static void main(String[] args) {
        System.out.println("Задача №1:");
        inverter();
        System.out.println("Задача №2:");
        filler();
        System.out.println("Задача №3:");
        multiplier();
        System.out.println("Задача №4:");
        square();
        System.out.println("Задача №5:");
        creator(6, 4);
        System.out.println("Задача №6:");
        System.out.printf("Минимальный элемент массива - %d\n", getMin());
        System.out.printf("Максимальный элемент массива - %d\n", getMax());
        System.out.println("Задача №7:");
        int[] example1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] example2 = {1, 1, 1, 2, 1};
        int[] example3 = {1, 14, 1, 2, 1, 6, 7};
        System.out.println(checkBalance(example1));
        System.out.println(checkBalance(example2));
        System.out.println(checkBalance(example3));
        System.out.println("Задача №8:");
        int[] input_array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(rearrange(input_array, -7)));
    }

    public static void inverter() {
        int[] arr = {0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void filler() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void multiplier() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void square() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == j) || (i + j == 4)) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void creator(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static Random random = new Random();
    public static int getMin() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int getMax() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static boolean checkBalance(int arr[]) {
        int LeftSum = 0;
        int RightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            RightSum += arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            LeftSum += arr[i];
            RightSum -= arr[i];
            if (LeftSum == RightSum) {
                return true;
            }
        }
        return false;
    }

    public static int[] rearrange(int[] arr, int n) {
        if (Math.abs(n) >= arr.length) {
            n = n % arr.length;
        }
        if (n < 0) {
            n += arr.length;
        }
        for (int j = 0; j < n; j++) {
            int subValue = arr[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[arr.length - 1 - i] = arr[arr.length - 2 - i];
            }
            arr[0] = subValue;
        }
        return arr;
    }
}