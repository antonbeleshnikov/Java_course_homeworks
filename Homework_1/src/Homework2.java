public class Homework2 {
    public static void main(String[] args) {
        System.out.println(SumCheck(5, 6));
        System.out.println(SumCheck(13, 7));
        System.out.println(SumCheck(32, 21));
        System.out.println(NumberCheck(15));
        System.out.println(NumberCheck(-23));
        System.out.println(NumberCheck2(15));
        System.out.println(NumberCheck2(-23));
        LineOutput(5, "hello");
        System.out.println(YearCheck(4444));
        System.out.println(YearCheck(3333));
        System.out.println(YearCheck(2000));
        System.out.println(YearCheck(1800));
    }

    public static boolean SumCheck(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else return false;
    }

    public static String NumberCheck(int a) {
        if (a >= 0) {
            return "Число положительное";
        } else return "Число отрицательное";
    }

    public static boolean NumberCheck2(int a) {
        if (a < 0) {
            return true;
        } else return false;
    }

    public static void LineOutput(int quantity, String line) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(line);
        }
    }

    public static boolean YearCheck(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else return true;
    }
}