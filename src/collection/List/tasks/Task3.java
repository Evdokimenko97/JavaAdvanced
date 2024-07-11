package collection.List.tasks;

import java.util.*;

/**
 * �������� ��������� �� Java, ������� ��������� ��������� ��������:
 * <p>
 * ������� ������ �� �����, ���������� ����� �� ���������� �����������.
 * ������������ ���������� ���������� ���� � ������.
 * ������� ���-3 ����� ������ ���� � ������.
 * �������� �������� ������ ���������� ���� � ���������� �������.
 * <p>
 * ["this", "is", "a", "test", "this", "test", "is", "a", "simple", "test", "of", "java", "collections", "java"]
 */
public class Task3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("this", "is", "a", "test", "this", "test", "is", "a", "simple", "test", "of", "java", "collections", "java"));
        counterWord(list).entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }

    private static Map<String, Integer> counterWord(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
}
