package lesson5;

import lesson5.Employee;

public class Homework5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван", "Middle dev", "ivanovivan3232@mail.ru",
                "89183232322", 100000, 30);
        employees[1] = new Employee("Белов Дмитрий", "Junior dev", "belovdmitriy2121@yandex.ru",
                "89192121221", 60000, 25);
        employees[2] = new Employee("Антон Петров", "Senior dev", "antonpetrov33@yandex.ru",
                "89163229898", 150000, 35);
        employees[3] = new Employee("Александрова Мария", "Junior dev", "alexandrovamariya@mail.ru",
                "89182328939", 60000, 23);
        employees[4] = new Employee("Эдуард Давыдов", "Team lead", "eduard99@yandex.ru",
                "89199981155", 250000, 45);
        for (int i=0;i<employees.length;i++) {
            if (employees[i].getAge() > 40) {
                employees[i].info();
            }
        }
    }
}
