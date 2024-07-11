package collection.List.tasks;

import java.util.*;

/**
 * Задача
 * Напишите программу на Java, которая выполняет следующие действия:
 *
 * Создает список из строк, содержащий имена нескольких людей.
 * Удаляет из списка все имена, начинающиеся с определенной буквы (например, буква "A").
 * Сортирует оставшиеся имена в алфавитном порядке.
 * Печатает итоговый список.
 */
public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Abba", "Biba", "Boba", "Bebra", "Abuba"));
        deleteNames(list);

        // Сортировка списка
        Collections.sort(list);
        System.out.println(list);
    }

    private static List<String> deleteNames(List<String> list) {
        list.removeIf(s -> s.startsWith("A"));
        return list;
    }
}
