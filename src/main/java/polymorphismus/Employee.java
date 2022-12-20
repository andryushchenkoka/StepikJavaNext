package polymorphismus;

public class Employee extends Person {

    private int inn;
    private int snils;

    public Employee(String firstName, String lastName, int age, int inn, int snils) {
        super(firstName, lastName, age);
        this.inn = inn;
        this.snils = snils;
    }

    public void greeting() {
        System.out.printf("Приветствую! Меня зовут %s %s и я - работник\n\n", this.getLastName(), this.getFirstName());
    }
}
