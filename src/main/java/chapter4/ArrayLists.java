package chapter4;

import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args) {

        // size - размер занятых ячеек (напр. 2/10 ячеек)
        // capacity - вместительность

        //createArrayList();
        //methodsOfArrayListOne();
        methodsOfArrayListTwo();
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

    public static void methodsOfArrayListTwo() {

        ArrayList<String> names = new ArrayList<>();

        ArrayList<String> pairNames = new ArrayList<>();
        pairNames.add("Sasha");
        pairNames.add("Alex");

        ArrayList<String> boyNames = new ArrayList<>();
        boyNames.add("Sasha");
        boyNames.add("Boris");
        boyNames.add("Petr");

        ArrayList<String> girlNames = new ArrayList<>();
        girlNames.add("Anna");
        girlNames.add("Sofia");
        girlNames.add("Sasha");


        // addAll() принимает в параметрах ArrayList, который будет добавлен к текущему листу
        names.addAll(boyNames); // [Sasha, Boris, Petr]
        System.out.println(names);

        // так же можно указать индекс куда вставить новый список
        names.addAll(0, girlNames); // [Anna, Sofia, Sasha, Sasha, Boris, Petr]
        System.out.println(names);


        // найти индекс первого вхождения элемента
        System.out.println(names.indexOf("Sasha")); // 2

        // найти индекс последнего вхождения элемента (идет с конца)
        System.out.println(names.lastIndexOf("Sasha")); // 3


        // isEmpty проверяет пустоту списка
        System.out.println(names.isEmpty());    // false
        names.clear();
        System.out.println(names.isEmpty());    // true


        // contains() проверяет содержание заданного элемента в списке
        names.addAll(girlNames);
        System.out.println(names.contains("Boris")); // false
        System.out.println(names.contains("Anna")); // true
    }
}
