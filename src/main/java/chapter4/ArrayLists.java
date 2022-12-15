package chapter4;

import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args) {

        // size - размер занятых ячеек (напр. 2/10 ячеек)
        // capacity - вместительность

        createArrayList();
        methodsOfArrayListOne();
    }

    public static void createArrayList() {

        // arraylist с начальной вместимостью 10.
        // Будет выше скорость работы, если указать заранее используемую вместимость
        // Если элементов больше - Java создаст новый список и скопирует туда все старые элементы + добавит новый

        ArrayList<String> names = new ArrayList<>(3);

        // Если передать лист в конструктор, Java скопирует все элементы указанного списка
        ArrayList<String> names2 = new ArrayList<>(names);

        // но ссылки будут разными
        System.out.println("Ссылки между двумя arrayList одинаковы: " + (names == names2));
        System.out.printf("\nSize первого списка: %d\nSize второго списка: %d", names.size(), names2.size());
    }

    public static void methodsOfArrayListOne() {

        ArrayList<String> names = new ArrayList<>();

        // add() добавляет элемент в конец
        names.add("Kirill");
        names.add("Alex"); // [Kirill, Alex]
        names.add("Alex"); // [Kirill, Alex, Alex]

        // можно указать индекс куда нужно добавить элемент
        names.add(1, "Sergey"); // [Kirill, Sergey, Alex, Alex]


        // get() возвращает элемент по указанному индексу
        System.out.println(names.get(0)); // Kirill


        // set() заменяет сущуествующий элемент на указанный
        System.out.println(names); // [Kirill, Sergey, Alex, Alex]
        names.set(1, "Nikita");
        System.out.println(names); // [Kirill, Nikita, Alex, Alex]


        // remove() удаляет первый подходящий элемент
        names.remove(0);      // [Nikita, Alex, Alex]
        names.remove("Alex");    // [Nikita, Alex]
        System.out.println(names);  // [Nikita, Alex]

        names.clear();

        // объекты удаляются по ссылке.
        // a1 === a2. Добавить а1, а затем удалить а2 - удалится один и тот же элемент, т.к. ссылки одинаковы.
        String a1 = "Alex";
        names.add(a1);              // [Alex]
        System.out.println(names);  // [Alex]
        String a2 = "Alex";
        names.remove(a2);           // []
        System.out.println(names);  // []
    }
}
