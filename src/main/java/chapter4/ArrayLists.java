package chapter4;

import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args) {

        // size - размер занятых ячеек (напр. 2/10 ячеек)
        // capacity - вместительность

        createArrayList();
    }

    public static void createArrayList(){

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
}
