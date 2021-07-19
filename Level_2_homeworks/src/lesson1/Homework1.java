package lesson1;

public class Homework1 {
    public static void main(String[] args) {
        Obstacles[] obstacles = {
                new RunningTrack(250), new Wall(1),
                new RunningTrack(3000), new Wall(1.5),
                new RunningTrack(10000), new Wall(4)};
        Athletes[] marathonRunners = {new Cat("Барсик"), new Human("Иван"), new Robot("Федор")};
        for (int i = 0; i < marathonRunners.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof RunningTrack) {
                    marathonRunners[i].run((RunningTrack) obstacles[j]);
                } else if (obstacles[j] instanceof Wall) {
                    marathonRunners[i].jump((Wall) obstacles[j]);
                }
            }
        }
    }
}
