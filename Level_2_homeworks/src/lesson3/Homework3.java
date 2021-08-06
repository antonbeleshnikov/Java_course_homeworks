package lesson3;

import java.util.HashMap;
import java.util.Map;

public class Homework3 {
    public static void main(String[] args) {
        String[] fruits = { "Apple", "Banana", "Pear", "Orange", "Garnet", "Apple", "Pear", "Apple", "Orange", "Cherry"};
        Map<String,Integer> counter = new HashMap<>();
        for (String x: fruits) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
        }
        System.out.println(counter);

        Directory direct = new Directory();
        String[] names = {"Иванов", "Петров"};
        direct.add("Иванов", "84991678273");
        direct.add("Иванов", "84953678363");
        direct.add("Иванов", "84994993333");
        direct.add("Петров", "84952129944");

        for (String name : names) {
            System.out.println("Фамилия: " + name + ", телефоны: " + direct.get(name));
        }
    }
}
