package lesson6;

public class Homework6 {
    public static void main(String[] args) {
        Cat pushok = new Cat("Пушок");
        pushok.run(150);
        pushok.swim(15);
        Dog bobik = new Dog("Бобик");
        bobik.run(400);
        bobik.swim(5);
        Dog sharik = new Dog("Шарик");
        printQuantity();
    }

    public static void printQuantity() {
        System.out.printf("Количество животных - %d, кошек - %d, собак - %d.\n",
                Animal.getAnimal_counter(), Cat.getCat_counter(), Dog.getDog_counter());
    }
}
