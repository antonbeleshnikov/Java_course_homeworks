package lesson6;

public class Animal {
    String name;
    private static int animal_counter;

    public Animal(String name) {
        this.name = name;
        animal_counter++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров");
    }

    public static int getAnimal_counter() {
        return animal_counter;
    }
}