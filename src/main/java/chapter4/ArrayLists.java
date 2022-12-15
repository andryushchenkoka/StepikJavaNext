package chapter4;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {

    public static void main(String[] args) {

        // size - размер занятых ячеек (напр. 2/10 ячеек)
        // capacity - вместительность

        //createArrayList();
        //methodsOfArrayListOne();
        //methodsOfArrayListTwo();
        //methodsOfArrayListThree();
        //methodsOfArrayListFour();
        methodsOfArrayListFive();
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

    public static void methodsOfArrayListThree() {

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


        // removeAll() удалит все совпадения с указанным списком
        boyNames.removeAll(pairNames);  // [Boris, Petr]
        System.out.println(boyNames);

        boyNames.add("Alex");           // [Boris, Petr, Alex]
        boyNames.add("Alex");           // [Boris, Petr, Alex, Alex]

        boyNames.removeAll(pairNames);  // [Boris, Petr]
        System.out.println(boyNames);


        // retainAll() оставит только те элементы, которые совпадают с указанным списком
        names.addAll(girlNames);        // [Anna, Sofia, Sasha]
        names.retainAll(pairNames);     // [Sasha]
        System.out.println(names);


        // containsAll() определяет, все ли элементы из указанного списка содержатся
        System.out.println(names.containsAll(pairNames));      // false. потому что в names не хватает Alex

        names.add(0, "Alex");                     // [Alex, Sasha]
        System.out.println(names.containsAll(pairNames));      // true
    }

    public static void methodsOfArrayListFour() {

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


        // subList() копирует в себя элементы из указанного списка в обозначенном интервале
        // sublist говорит Я беру себе с 1 по 4 (не включая) элементы из списка names
        names.addAll(boyNames);     // [Sasha, Boris, Petr]
        names.addAll(girlNames);    // [Sasha, Boris, Petr, Anna, Sofia, Sasha]

        List<String> sublist = names.subList(1, 4);     // [Boris, Petr, Anna] - элемент to не входит в интервал
        System.out.println(sublist);

        // sublist не является самостоятельной сущностью. sublist - это представление (view) листа names.
        // если в sublist добавить элемент, он будет добавлен и в names

        sublist.add("Vadim");
        System.out.println(sublist); // [       Boris, Petr, Anna, Vadim]  sublist стал с 1 по 5 элемент, а не по 4
        System.out.println(names);   // [Sasha, Boris, Petr, Anna, Vadim, Sofia, Sasha]

        System.out.println("Сравнение ссылок sublist и names: " + (sublist == names));  // false


        // все изменения в names должны быть сделаны с помозью view (sublist), наче выпадет Concurrent Exception
        //names.remove("Sasha");
        //System.out.println(names);      // [Sasha, Boris, Petr, Anna, Vadim, Sofia, Sasha]
        //System.out.println(sublist);    // throws new Concurrent Exception


        // toArray() создает массив элементов из списка
        Object[] objArr = names.toArray();
        String[] strArr = names.toArray(new String[0]);
        for (Object o : objArr)
            System.out.println("Object : " + o); // [Sasha, Boris, Petr, Anna, Vadim, Sofia, Sasha]
        for (String s : strArr)
            System.out.println("String : " + s); // [Sasha, Boris, Petr, Anna, Vadim, Sofia, Sasha]
        System.out.println("Сравнение ссылок sublist и names: " + (sublist == names));  // false
    }

    public static void methodsOfArrayListFive() {

        ArrayList<String> pairNames = new ArrayList<>();
        pairNames.add("Sasha");
        pairNames.add("Alex");


        // listOf - созданный лист не может содержать null, а также нельзя модифицировать (добавлять, изменять)
        List<Integer> listInt = List.of(1, 3, 2, 4, 3, 5);
        System.out.println(listInt);    // [1, 3, 2, 4, 3, 5]


        // copyOf
        List<String> listStr = List.copyOf(pairNames);
        System.out.println(listStr);    // [Sasha, Alex]
    }
}
