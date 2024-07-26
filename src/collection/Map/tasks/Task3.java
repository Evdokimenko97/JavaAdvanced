package collection.Map.tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ������
 * �������� ��������� �� Java, ������� ��������� ��������� ��������:
 * <p>
 * ������ ������ �� �����, �������������� �����������.
 * ��� ������� ����������� ������������ ���������� ����.
 * ������� ������� (Map), ��� ������ �������� �����������, � ��������� � ���������� ���� � ���� �����������.
 * ��������� ������� �� ���������� ���� � ������������.
 * �������� ��������������� �������.
 * <p>
 * ������: ["This is a test", "Java collections are powerful energy", "Sorting is useful"]
 */
public class Task3 {
    public static void main(String[] args) {
        // ������ ������ �� �����, �������������� �����������.
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("This is a test", "This is b test", "Java collections are powerful energy", "Sorting is useful"));

        System.out.println("��� ������� ����������� ������������ ���������� ����.");
        Map<String, Integer> mapWords = new HashMap<>();
        for (String s : arrayList) {
            mapWords.put(s, s.split(" ").length);
        }
        mapWords.forEach((s, integer) -> System.out.println(s + ": " + integer));
        System.out.println();

        System.out.println("��������� ������� �� ���������� ���� � ������������.");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapWords.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        result.forEach((s, integer) -> System.out.println(s + ": " + integer));
    }
}
