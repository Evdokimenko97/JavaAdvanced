package collection.ArrayList.tasks;

import java.util.*;

/**
 * Напишите программу на Java, которая выполняет следующие действия:
 *
 * Создает список из чисел от 1 до 20.
 * Удаляет из списка все четные числа.
 * Удваивает все оставшиеся элементы.
 * Печатает итоговый список.
 */
public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        List<Integer> integers = deleteNumbers(list);
        System.out.println(multiplyOn2(integers));
    }

    private static List<Integer> deleteNumbers(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        return list;
    }

    private static List<Integer> multiplyOn2(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i) * 2;
            list.set(i, number);
        }
        return list;
    }

//    private static List<Integer> deleteNumbers(List<Integer> list) {
//        list.removeIf(integer -> integer % 2 == 0);
//        return list;
//    }
//
//    private static List<Integer> multiplyOn2(List<Integer> list) {
//        list.replaceAll(integer -> integer * 2);
//        return list;
//    }
}
