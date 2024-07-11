package collection.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods5 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Kolya");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Ivan");
        arrayList2.add("Mariya");
        arrayList2.add("Igor");

        // метод removeAll удаляет все элементы, находящиеся в первом массиве. Если такого элемента нет, то пропускает его.
//        arrayList1.removeAll(arrayList2);
//        System.out.println(arrayList1);

        // Метод retainAll оставит элементы, находящиеся в массиве
//        arrayList1.retainAll(arrayList2);
//        System.out.println(arrayList1);

        // Метод containsAll сравнивает есть ли все элементы в одной коллекции по отношению к другой
        boolean result = arrayList1.containsAll(arrayList2);
        System.out.println(result);

        // subList берёт интервал [1, 4)
        List<String> myList = arrayList1.subList(1, 4);
        System.out.println(myList);

        // Перевод коллекции в массив
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Zaur");
        arrayList3.add("Ivan");
        arrayList3.add("Mariya");
        arrayList3.add("Kolya");
        Object[] array = arrayList3.toArray();
        String[] array2 = arrayList3.toArray(new String[0]);

        for (String s: array2) {
            System.out.println(s);
        }

        // Железобетонно фиксирует коллекцию в её инициализации (UnsupportedOperationException при изменении коллекции)
        List<String> arrayList4 = List.of("A", "B", "C");
        System.out.println(arrayList4);

        List<String> arrayList5 = List.copyOf(arrayList4);
        System.out.println(arrayList5);
    }
}
