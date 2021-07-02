package lesson2;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println(sumCheck(5, 6));
        System.out.println(sumCheck(13, 7));
        System.out.println(sumCheck(32, 21));
        numberCheck(15);
        numberCheck(-23);
        System.out.println(numberCheck2(15));
        System.out.println(numberCheck2(-23));
        lineOutput(5, "hello");
        System.out.println(yearCheck(4444));
        System.out.println(yearCheck(3333));
        System.out.println(yearCheck(2000));
        System.out.println(yearCheck(1800));
    }

    public static boolean sumCheck(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else return false;
    }

    public static void numberCheck(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else System.out.println("Число отрицательное");
    }

    public static boolean numberCheck2(int a) {
        if (a < 0) {
            return true;
        } else return false;
    }

    public static void lineOutput(int quantity, String line) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(line);
        }
    }

    public static boolean yearCheck(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else return true;
    }
}