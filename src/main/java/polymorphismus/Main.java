package polymorphismus;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Иван", "Человеков", 25);
        Employee employee = new Employee("Михаил", "Зубенко", 42, 12345678, 1901234561);
        Proger proger = new Proger("Стив", "Джобс", 37, 61486126, 512435612, "Swift", "Senior");

        Person[] personsArr = {person, employee, proger};
        massGreeting(personsArr);
    }

    public static <T extends Person> void massGreeting(T[] array){
        for (T item : array)
            item.greeting();
    }
}
