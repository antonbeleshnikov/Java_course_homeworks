package lesson1;

import lesson1.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxWithFruits<T extends Fruit> {
    private List<T> container;

    public BoxWithFruits() {
        this.container = new ArrayList<>();
    }
    public BoxWithFruits(T... fruits) {
        this.container = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float w = 0.0f;
        for (T fruit : container) {
            w += fruit.getWeight();
        }
        return w;
    }

    public boolean compare(BoxWithFruits<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00000001;
    }

    public void transfer (BoxWithFruits<? super T> another) {
        if (another == this) {
            return;
        }
        another.container.addAll(this.container);
        this.container.clear();
    }

    public void add(T fruit) {
        container.add(fruit);
    }
}
