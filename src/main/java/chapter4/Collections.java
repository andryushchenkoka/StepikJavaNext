package chapter4;

import java.util.LinkedList;

public class Collections {

    public static void main(String[] args) {

        linkedList();
    }

    // 4.7 LinkedList
    public static void linkedList(){
        String name1 = "Alex",
                name2 = "Kirill",
                name3 = "Sergey";

        LinkedList<String> names = new LinkedList<>();

        // add()

        names.add(name1);
        System.out.println(names); // [Alex]
        // у name1 нет ссылки на следующий элемент, поэтому null

        names.add(name3);
        System.out.println(names); // [Alex, Sergey]
        // теперь name1 содержит ссылку на name3, а name3 ссылается на null

        names.add(1, name2);
        System.out.println(names); // [Alex, Kirill, Sergey]
        // при вставке элемента в середине были лишь изменены ссылки у name1 и name3
        // остальные элементы linkedList не были затронуты.

        // remove()

        names.remove(0);
        System.out.println(names); // [Kirill, Sergey]
    }
}
