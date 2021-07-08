package lesson6;

public class Dog extends Animal {
    private static int dog_counter;

    public Dog(String name) {
        super(name);
        dog_counter++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака не может пробежать больше 500м");
        } else {
            System.out.println(name + " пробежал " + distance + " метров");
        }
    }

    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака не может проплыть больше 10м");
        } else {
            System.out.println(name + " проплыл " + distance + " метров");
        }
    }

    public static int getDog_counter() {
        return dog_counter;
    }
}
