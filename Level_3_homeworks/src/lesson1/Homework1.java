package lesson1;

import lesson1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        swapElements(arr,1,2);
        ArrayList<Integer> arrayList= arrayToList(arr);
        System.out.println(arrayList);

        BoxWithFruits<Orange> boxWithOranges = new BoxWithFruits<>();
        boxWithOranges.add(new Orange());
    }

    public static <T> ArrayList<T> arrayToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static <T> void swapElements(T[] arr, int index1, int index2) {
        T obj = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = obj;
    }
}
