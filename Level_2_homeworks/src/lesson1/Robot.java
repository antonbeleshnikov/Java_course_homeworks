package lesson1;

public class Robot implements Athletes {
    private final double DISTANCE_LIMIT = 20000;
    private final double HEIGHT_LIMIT = 5;
    private String name;
    private boolean isStopped;

    public Robot(String name) {
        this.name = name;
    }

    public void run(RunningTrack runningTrack) {
        if (isStopped == true) {
            System.out.println("Робот " + name + " не смог преодолеть препятствие, т.к остановился");
        } else if (runningTrack.getLength() > DISTANCE_LIMIT) {
            System.out.println("Робот " + name + " не смог пробежать дорожку, " +
                    "т.к ограничение на расстояние бега - " + DISTANCE_LIMIT);
            isStopped = true;
        } else {
            System.out.println("Робот " + name + " пробежал " + runningTrack.getLength() + " метров");
        }
    }

    public void jump(Wall wall) {
        if (isStopped == true) {
            System.out.println("Робот " + name + " не смог преодолеть препятствие, т.к остановился");
        } else if (wall.getHeight() > HEIGHT_LIMIT) {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену, " +
                    "т.к ограничение на высоту прыжка - " + HEIGHT_LIMIT);
            isStopped = true;
        } else {
            System.out.println("Робот " + name + " подпрыгнул на " + wall.getHeight() + " метров");
        }
    }
}
