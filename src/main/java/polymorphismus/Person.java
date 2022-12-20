package polymorphismus;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void greeting() {
        System.out.printf("Приветствую! Меня зовут %s %s и я - человек\n\n", this.getLastName(), this.getFirstName());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
