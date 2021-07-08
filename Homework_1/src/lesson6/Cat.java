package lesson6;

public class Cat extends Animal {
    private static int cat_counter;

    public Cat(String name) {
        super(name);
        cat_counter++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот не может пробежать больше 200м");
        } else {
            System.out.println(name + " пробежал " + distance + " метров");
        }
    }

    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }

    public static int getCat_counter() {
        return cat_counter;
    }
}
