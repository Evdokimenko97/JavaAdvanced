package collection.List.ArrayList;

import java.util.ArrayList;

public class ArrayListMethods1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add(1, "Misha");

        for (String s: arrayList1) {
            System.out.println(s + " ");
        }

        // Метод get (получает элемент)
        System.out.println();
        System.out.println(arrayList1.get(2));

        // Метод set (заменяет элемент)
        System.out.println();
        arrayList1.set(2, "Mariya");
        System.out.println(arrayList1);

        // Метод remove (удаляет элемент и смещает коллекцию влево)
        arrayList1.remove("Mariya");
        System.out.println(arrayList1);
    }
}
