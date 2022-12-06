package chapter3.Igra;

public class Game {

    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Василий", 13);
        Schoolar schoolar2 = new Schoolar("Иван", 14);

        Employee employee1 = new Employee("Александр", 31);
        Employee employee2 = new Employee("Вячеслав", 34);

        Team<Schoolar> schoolarTeam = new Team<>("Зумеры");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team<Employee> employeeTeam = new Team<>("Бумеры");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        schoolarTeam.playWith(schoolarTeam);
    }
}
