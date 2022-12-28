package chapter4;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {

    public static void main(String[] args) {
        hashMapFirst();
    }

    // 4.13 Введение в HashMap
    // HashMap не запоминает порядок добавления
    // Ключи должны быть уникальными. При одинаковых ключах, значение перезапишется
    // Значение value допускается любым
    // И ключ и значение могут быть NULL
    public static void hashMapFirst(){

        Map<Integer, String> passport = new HashMap<>();

        passport.put(123, "Ivan Petrov");
        passport.put(234, null);
        passport.put(345, "Kirill Sergeev");
        passport.put(null, "Ivan Ivanov");
        System.out.println(passport); // {null=Ivan Ivanov, 345=Kirill Sergeev, 234=null, 123=Ivan Petrov}

        // putIfAbsent - добавить элемент, если такого еще нет в мапе
        passport.putIfAbsent(123, "Igor Vasin");
        passport.putIfAbsent(234, "Boris Mikhailov");
        passport.putIfAbsent(null, "Valeriy Kharlamov");
        System.out.println(passport); // {null=Ivan Ivanov, 345=Kirill Sergeev, 234=Boris Mikhailov, 123=Ivan Petrov}

        // get
        System.out.printf("%d : %s\n\n", 123, passport.get(123)); // 123 : Ivan Petrov

        // remove
        passport.remove(345);
        System.out.println(passport); // {null=Ivan Ivanov, 234=Boris Mikhailov, 123=Ivan Petrov}

        // containsKey
        System.out.println(passport.containsKey(null)); // true

        // containsValue
        System.out.println(passport.containsValue("Boris Mikhailov")); // true

        // keySet - возвращает множество ключей
        System.out.println(passport.keySet()); // [null, 234, 123]

        // values - возвращает множество ключей
        System.out.println(passport.values()); // [Ivan Ivanov, Boris Mikhailov, Ivan Petrov]
    }
}
