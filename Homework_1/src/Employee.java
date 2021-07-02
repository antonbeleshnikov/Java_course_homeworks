public class Employee {
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String telephone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("ФИ сотрудника: " + name + ", должность - " + position + ", email - " + email
                + ", телефон - " + telephone + ", зарплата - " + salary + ", возраст - " + age);
    }

    public int getAge() {
        return age;
    }
}
