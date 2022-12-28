package chapter4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodes {

    // 4.14 equals и hashCode
    // Если переопределили equals(), то нужно переопределить и hashCode()
    // Коллизия - ситуация совпадения хеш кодов у разных по equals() объектов. Чем меньше случаев коллизии, тем лучше.
    // Если объекты равны по equals, то hashcode этих объектов тоже должны быть одинаковыми
    // Если объект НЕ равны по equals, то hashcode этих объект НЕ обязательно должен быть разным:
    // т.к hashcode это преобразование в int, а у int есть свой диапазон значений, то
    // кол-во объектов может превысить кол-во значений int, следовательно, может появляться коллизия

    public static void main(String[] args) {
        Map<Student, Double> studentMap = new HashMap<>();

        Student st1 = new Student("Kirill", "Andreev", 3);
        Student st2 = new Student("Igor", "Petrov", 4);
        Student st3 = new Student("Nikita", "Ivanov", 3);

        studentMap.put(st1, 4.8);
        studentMap.put(st2, 4.3);
        studentMap.put(st3, 3.7);

        Student st4 = new Student("Kirill", "Andreev", 3);
        System.out.println(studentMap.containsKey(st4)); // false, нужно переопределить hashCode()
        System.out.println(st1.equals(st4));
        System.out.println("st1 hashcode: " + st1.hashCode()); // без переопределенного hashCode(), хеши будут отличаться
        System.out.println("st4 hashcode: " + st4.hashCode()); // с переопределенным hashCode(), хеши будут совпадать
    }
}

class Student {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course
                && Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }
}
