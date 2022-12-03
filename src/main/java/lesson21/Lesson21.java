package lesson21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        printArray(listEmp);

        listEmp.sort(new IdComparator());       // вызов сортировщика по id
        printArray(listEmp);

        listEmp.sort(new NameComparator());     // вызов сортировщика по name
        printArray(listEmp);

        listEmp.sort(new SalaryComparator());   // вызов сортировщика по salary
        printArray(listEmp);
    }

    // метод вывода элементов списка
    static void printArray(List<Employee> empList) {
        System.out.println("===================================");
        for (Employee employee : empList) {
            System.out.println(employee.id + " " + employee.firstName + " " + employee.lastName + " " + employee.salary);
        }
        System.out.println("===================================");
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

// LESSON 2.2
class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Integer.compare(emp1.id, emp2.id);
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int result = emp1.firstName.compareTo(emp2.firstName);  // сортировка по String полю
        if (result == 0) {
            result = emp1.lastName.compareTo(emp2.lastName);
        }

        return result;
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Integer.compare(emp1.id, emp2.id);
    }
}