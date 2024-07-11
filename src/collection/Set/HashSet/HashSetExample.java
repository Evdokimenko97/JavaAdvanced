package collection.Set.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zaur");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");

        System.out.println(set);

        // ����� remove
        set.remove("Oleg");

        // ����� size
        System.out.println(set);
        System.out.println(set.size());
    }
}
