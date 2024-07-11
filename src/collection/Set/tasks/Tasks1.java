package collection.Set.tasks;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Тестовое задание
 * Создайте класс SetTester, который будет выполнять следующие действия:
 *
 * Создайте экземпляры HashSet, TreeSet и LinkedHashSet.
 * Добавьте в каждый набор набор чисел: 10, 5, 1, 2, 10, 3, 7, 8, 6, 4.
 * Выведите элементы каждого набора.
 * Проверьте наличие числа 5 в каждом наборе.
 * Удалите число 2 из каждого набора.
 * Сравните количество элементов в каждом наборе после удаления.
 * Очистите каждый набор и проверьте, что каждый набор пуст.
 *
 */
public class Tasks1 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(5);
        set.add(1);
        set.add(2);
        set.add(10);
        set.add(3);
        set.add(7);
        set.add(8);
        set.add(6);
        set.add(4);
        System.out.println(set);
        System.out.println(set.contains(5));

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(10);
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(8);
        treeSet.add(6);
        treeSet.add(4);
        System.out.println(treeSet);
        System.out.println(treeSet.contains(5));

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(5);
        lhs.add(1);
        lhs.add(2);
        lhs.add(10);
        lhs.add(3);
        lhs.add(7);
        lhs.add(8);
        lhs.add(6);
        lhs.add(4);
        System.out.println(lhs);
        System.out.println(lhs.contains(5));
    }
}
