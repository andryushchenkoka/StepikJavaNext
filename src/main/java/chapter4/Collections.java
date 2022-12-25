package chapter4;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;

public class Collections {

    public static void main(String[] args) {

        //linkedList();
        listIterator();
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

    // 4.8 ListIterator
    public static void listIterator(){

        // определение на пaлиндром

        String palindrome = "Rotor";

        LinkedList<Character> list = new LinkedList<>();

        for(char c : palindrome.toLowerCase().toCharArray()){
            list.add(c);
        }

        ListIterator<Character> listIteratorLeft = list.listIterator();              // итератор ->
        ListIterator<Character> listIteratorRight = list.listIterator(list.size());  // итератор <-

        boolean isPalindrome = true;

        while (listIteratorLeft.hasNext() && listIteratorRight.hasPrevious()){
            if(listIteratorLeft.next() != listIteratorRight.previous()){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome) System.out.println("is palindrome");
        else System.out.println("is not palindrome");
    }
}
