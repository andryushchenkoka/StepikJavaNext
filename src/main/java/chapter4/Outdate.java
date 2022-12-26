package chapter4;

import java.util.Stack;
import java.util.Vector;

public class Outdate {

    public static void main(String[] args) {

        //vector();
        stack();
    }

    // 4.11 Vector
    // Vector - устаршевий synchronized класс. Не рекомендуется для использования
    // Рекомендуется использовать ArrayList
    public static void vector() {

        Vector<String> nums = new Vector<>();

        nums.add("Uno");
        nums.add("Dos");
        nums.add("Tres");
        nums.add("Cuatro");

        System.out.println(nums);
        System.out.println(nums.firstElement());
        System.out.println(nums.get(1));
        System.out.println(nums.lastElement());
    }

    // 4.12 Stack
    // Stack - использует принцип LIFO - Last In First Out
    // Не рекомендуется для использования
    public static void stack() {
        Stack<String> books = new Stack<>();

        // push - добавить элемент на верх стека
        books.push("Война и мир");
        books.push("Евгений Онегин");
        books.push("Мастер и Маргарита");
        System.out.println(books);  // низ - [Война и мир, Евгений Онегин, Мастер и Маргарита] - верх стека

        // pick - возвращает верхний элемент
        System.out.println("Верхний элемент peek(): " + books.peek()); // Мастер и Маргарита

        // pop - возвращает верхний элемент и удаляет его
        while (!books.isEmpty()) {
            String book = books.pop();
            System.out.printf("Взятый элемент: %s\nСтек: %s \n\n", book, books);
        }
    }
}
