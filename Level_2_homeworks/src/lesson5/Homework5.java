package lesson5;

public class Homework5 {

    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("First thread time " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i<h; i++) {
                a2[i] = (float) (arr[i+h] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1,0,arr,0,h);
        System.arraycopy(a2,0,arr,h,h);
        System.out.println("Second thread time " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}