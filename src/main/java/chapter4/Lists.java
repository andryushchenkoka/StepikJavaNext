package chapter4;

import java.util.*;

public class Lists {

    public static void main(String[] args) {

        //linkedList();
        //listIterator();
        binarySearch();
    }

    // 4.7 LinkedList
    public static void linkedList() {
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
    public static void listIterator() {

        // определение на пaлиндром

        String palindrome = "Rotor";

        LinkedList<Character> list = new LinkedList<>();

        for (char c : palindrome.toLowerCase().toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> listIteratorLeft = list.listIterator();              // итератор ->
        ListIterator<Character> listIteratorRight = list.listIterator(list.size());  // итератор <-

        boolean isPalindrome = true;

        while (listIteratorLeft.hasNext() && listIteratorRight.hasPrevious()) {
            if (listIteratorLeft.next() != listIteratorRight.previous()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) System.out.println("is palindrome");
        else System.out.println("is not palindrome");
    }

    // 4.9 Binary Search
    // ПРЕДУСЛОВИЕ: массив должен быть заранее отсортирован
    // Метод поиска элемента с Binary Search заключается в постоянном делении массива пополам.
    // Крайний элемент левой разделенной части сравнивается с искомым числом
    public static void binarySearch() {

        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(-120);
        nums.add(17);
        nums.add(9);
        nums.add(-9);
        nums.add(28);
        nums.add(0);
        nums.add(-67);
        nums.add(28);
        System.out.println("Unsorted list: " + nums);  // [-120, 17, 9, -9, 28, 0, -67, 28]

        Collections.sort(nums);
        System.out.println("Sorted list: " + nums);  // [-120, -67, -9, 0, 9, 17, 28, 28]
        int resultNum = Collections.binarySearch(nums, 28);  // т.к в списке два числа 28, то будет найдено первое
        System.out.println("result Num: " + resultNum); // 6     - вывод индекса искомого элемента
        // если искомого элемента нет в массиве, то будет возвращено отриц. число

        // с массивами
        String[] names = {"Petr", "Boris", "Sergey", "Alex", "Kirill"};
        Arrays.sort(names);     // "Alex", "Boris", "Kirill", "Petr", "Sergey"
        int resultName = Arrays.binarySearch(names, "Kirill");
        System.out.println("result Name: " + resultName); // 2     - вывод индекса искомого элемента


        // сортировать
        Collections.sort(nums);
        System.out.println("Sorted list: " + nums);

        // перевернуть, отразить
        Collections.reverse(nums);
        System.out.println("Reversed list: " + nums);

        // перемешать
        Collections.shuffle(nums);
        System.out.println("Shuffled list: " + nums);
    }
}
