package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Тарелка содержит " + food + " единиц еды");
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void addFood(int n) {
        food += n;
    }

    public int getFood() {
        return food;
    }
}
