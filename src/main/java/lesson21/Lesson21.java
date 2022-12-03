package lesson21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lesson21 {

    public static void main(String[] args) {

        // сортировка списка с примитивными значениями

        List<String> list = new ArrayList<>();
        list.add("Kirill");
        list.add("Anna");
        list.add("Alex");

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

        // сортировка списка с объектами класса Employee

        Employee emp1 = new Employee(3, "Maria", "Popova", 30800);
        Employee emp2 = new Employee(1, "Vasiliy", "Basta", 50000);
        Employee emp3 = new Employee(2, "Andrew", "Lukin", 80000);

        List<Employee> listEmp = new ArrayList<>();

        listEmp.add(emp1);
        listEmp.add(emp2);
        listEmp.add(emp3);

        System.out.println(listEmp.toString());

        Collections.sort(listEmp);

        System.out.println(listEmp);
    }

}

// для сортировки списка как listEmp, нужно реализовать интерфейс Comparable (сравнимость)
// т.к. Java не знает по какому именно полю ей нужно отсортировать список

// интерфейс Comparable использует для сортировки естесственный порядок - от меньшего с большему и от А к Я
class Employee implements Comparable<Employee> {

    Integer id; // Integer id; для сортировки по id
    String firstName;
    String lastName;
    int salary;

    public Employee(Integer id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        return Integer.compare(this.id, anotherEmp.id);       // сортировка по Integer полю
//        int result = this.firstName.compareTo(anotherEmp.firstName);  // сортировка по String полю
//        if (result == 0){
//            result = this.lastName.compareTo(anotherEmp.lastName);
//        }
//
//        return result;
    }
}
