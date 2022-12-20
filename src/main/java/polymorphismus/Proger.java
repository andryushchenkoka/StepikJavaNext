package polymorphismus;

public class Proger extends Employee {

    private String lang;
    private String level;

    public Proger(String firstName, String lastName, int age, int inn, int snils, String lang, String level) {
        super(firstName, lastName, age, inn, snils);
        this.lang = lang;
        this.level = level;
    }

    public void greeting() {
        System.out.printf("Приветствую! Меня зовут %s %s и я - разработчик\n\n", this.getLastName(), this.getFirstName());
    }
}
