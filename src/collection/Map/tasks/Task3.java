package collection.Map.tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Задача
 * Напишите программу на Java, которая выполняет следующие действия:
 * <p>
 * Читает список из строк, представляющих предложения.
 * Для каждого предложения подсчитывает количество слов.
 * Создает словарь (Map), где ключом является предложение, а значением — количество слов в этом предложении.
 * Сортирует словарь по количеству слов в предложениях.
 * Печатает отсортированный словарь.
 * <p>
 * Пример: ["This is a test", "Java collections are powerful energy", "Sorting is useful"]
 */
public class Task3 {
    public static void main(String[] args) {
        // Читает список из строк, представляющих предложения.
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("This is a test", "This is b test", "Java collections are powerful energy", "Sorting is useful"));

        System.out.println("Для каждого предложения подсчитывает количество слов.");
        Map<String, Integer> mapWords = new HashMap<>();
        for (String s : arrayList) {
            mapWords.put(s, s.split(" ").length);
        }
        mapWords.forEach((s, integer) -> System.out.println(s + ": " + integer));
        System.out.println();

        System.out.println("Сортирует словарь по количеству слов в предложениях.");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapWords.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        result.forEach((s, integer) -> System.out.println(s + ": " + integer));
    }
}
