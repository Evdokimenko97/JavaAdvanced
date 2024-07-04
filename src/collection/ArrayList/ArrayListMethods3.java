package collection.ArrayList;

import java.util.ArrayList;

public class ArrayListMethods3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        arrayList1.add("Ivan");
        System.out.println(arrayList1);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("!!!");
        arrayList2.add("???");

//        // Метод addAll
//        arrayList1.addAll(arrayList2);
//        System.out.println(arrayList1);

        // Метод addAll + index
        arrayList1.addAll(1, arrayList2);
        System.out.println(arrayList1);

        // Метод indexOf ищет позицию (-1, потому что ищет по equals, который нужно переопределить)
        // Ищет первое нахождение элемента
        System.out.println(arrayList1.indexOf("Ivan"));
        // Ищет последнее нахождение элемента
        System.out.println(arrayList1.lastIndexOf("Ivan"));

        // Метод clear
        arrayList1.clear();
        System.out.println(arrayList1);

        // Размер
        System.out.println(arrayList1.size());

        // Пустая ли коллекция
        System.out.println(arrayList1.isEmpty());
    }
}
