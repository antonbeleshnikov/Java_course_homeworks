package lesson7;

public class Homework7 {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик", 20);
        cats[1] = new Cat("Барсик", 15);
        cats[2] = new Cat("Пушок", 20);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
        }
    }
}
