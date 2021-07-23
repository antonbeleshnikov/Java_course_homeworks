package lesson1;

public class RunningTrack implements Obstacles {
    private double length;

    public RunningTrack(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
