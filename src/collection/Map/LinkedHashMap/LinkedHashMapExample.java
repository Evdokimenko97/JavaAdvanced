package collection.Map.LinkedHashMap;

import collection.Map.HashMap.Student;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
//        LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>();
        // –азмер = 16, загруженность перед созданием большей мапы = 0.75, accessOrder = добавление в конец последнего использованного ключа
        LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Marya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Igorevich", 5);
        Student st5 = new Student("Vasilyi", "Vasilievich", 1);

        // ћетоды put
        linkedHashMap.put(5.8, st1);
        linkedHashMap.put(9.3, st2);
        linkedHashMap.put(7.2, st3);
        linkedHashMap.put(8.7, st4);
        linkedHashMap.put(7.9, st5);

        System.out.println(linkedHashMap);
    }
}
