package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Directory {
    private HashMap<String, Set<String>> numbers = new HashMap<>();

    public void add(String name, String number) {
        Set<String> existingNumbers = numbers.getOrDefault(name, new HashSet<>());
        existingNumbers.add(number);
        numbers.put(name, existingNumbers);
    }

    public Set<String> get(String name) {
        return numbers.get(name);
    }
}
