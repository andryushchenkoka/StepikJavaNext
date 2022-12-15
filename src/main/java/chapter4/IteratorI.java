package chapter4;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorI {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(3);
        nums.add(-7);
        nums.add(80);
        nums.add(-126);

        Iterator<Integer> iterator = nums.iterator(); // инициализация итератора

        // итератор ведет свой курсор по коллекции и определяет есть ли следующий элемент на очереди (итерации)
        // обязательно нужно 1.проверить наличие следующего элемента hasNext() и 2.перейти дальше next()
        while(iterator.hasNext()){
            int nextInt = iterator.next();
            if(nextInt > 0){
                System.out.println(nextInt);
            }
        }
    }
}
