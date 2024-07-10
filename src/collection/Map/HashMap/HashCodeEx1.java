package collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeEx1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Marya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);

        Student st4 = new Student("Zaur", "Tregulov", 3);
        Student st5 = new Student("Igor", "Sidorov", 4);
        System.out.println(st1.hashCode());
        System.out.println(st4.hashCode());

        for (Map.Entry<Student, Double> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

//        boolean result = map.containsKey(st4);
//        System.out.println(result);
    }
}

