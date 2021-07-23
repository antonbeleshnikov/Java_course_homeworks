package lesson1.AdditionalTask;

public class Main {
    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.MONDAY);
        getWorkingHours(DayOfWeek.TUESDAY);
        getWorkingHours(DayOfWeek.WEDNESDAY);
        getWorkingHours(DayOfWeek.THURSDAY);
        getWorkingHours(DayOfWeek.FRIDAY);
        getWorkingHours(DayOfWeek.SATURDAY);
        getWorkingHours(DayOfWeek.SUNDAY);
    }

    public static void getWorkingHours(DayOfWeek dayOfWeek) {
        if ((dayOfWeek.ordinal() == 5) || (dayOfWeek.ordinal() == 6)) {
            System.out.println("Сегодня выходной");
        } else {
            System.out.printf("Рабочих часов до конца недели - %d\n", (5 - dayOfWeek.ordinal()) * 8);
        }
    }
}