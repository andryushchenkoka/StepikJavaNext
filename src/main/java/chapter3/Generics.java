package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        // в правой части всегда нужно ставить угловые скобки <>
        List<String> list = new ArrayList<>();

        // парамеитризованный класс
        Info<Integer> info1 = new Info<>(26);
        Info<String> info2 = new Info<>("twenty six");

        System.out.println(info1.getValue());
        System.out.println(info2.outString());

        // параметризованный класс с несколькими переменными
        Pair<String, Integer> pair1 = new Pair<>("age", 21);
        System.out.println(pair1.getKey());
    }
}

// параметризованный класс с 1 переменной
class Info<T> {
    private T value;

    public Info(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String outString() {
        return "{[" + value + "]}";
    }
}

// параметризованный класс с несколькими переменными
// можно использовать цифры, напр. V1, V2
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// параметризованный метод с использованием дженерика
class ParamMethod {
    // <Т> указывает что используются дженерики,
    // T возвращаемый тип
    // это же Т в ArrayList
    public static <T> T parametrisedMethod(ArrayList<T> list) {
        return list.get(0);
    }
}

// IDEA не допускает использование одноименных типов (одна <T> для класса, другая отдельно для метода)
class Example<T> {

//    private T value;
//
//    Example(T value) {
//        this.value = value;
//    }
//
//    public <T> T getValue() {
//        return value;
//    }
}

// type erasure - стирание типов. Дженерики нужны компилятору, но для JVM результат компиляции приходит без дженериков.
// следовательно методы разные на этапе компиляции могут быть одинаковыми для JVM
class TypeErasure {

    // разница этих методов в используемом типе данных в дженериках

//    public void oneMethod(Example<String> value){
//
//    }
//
//    public void oneMethod(Example<Integer> value){
//
//    }
}

// type erasure возникает и при overriding метода наследника, потому что метод родителя есть и у наследника
// т.е не важно - перезаписываются два собственных метода или 1 наследованный и 1 собственный
class Parent {

    public void abc(Info<String> info) {

    }

}

class Child extends Parent {
//    компилятор ругается на type erasure в этом методе (разница в String и Integer в параметрах)

//    public void abc(Info<Integer> info){
//
//    }
}