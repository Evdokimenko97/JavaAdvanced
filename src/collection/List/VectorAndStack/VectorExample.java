package collection.List.VectorAndStack;

import java.util.Arrays;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Arrays.asList("Zaur", "Misha", "Oleg", "Katya"));
        System.out.println(vector);
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());

        vector.remove(2);
        System.out.println(vector);
        System.out.println(vector.get(1));
    }
}
