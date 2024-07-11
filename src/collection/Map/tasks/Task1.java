package collection.Map.tasks;

import java.util.*;

/**
 * ����������:
 * ��������� ������ ��������� ������ ������.
 * ��������� ������ ������� ������ �� ����� (����� ����������� ���������, ��������, �������, ���������������� � ��������������� �������).
 * ��������� ������ ���������� ���������� ��������� ������� ����� � ������.
 * ��������� ������ ������� ������ ����� � ��� �������.
 *
 * ������ �����: "Hello, world! Hello everyone. This is a test. Hello world?"
 * ������ ������: Hello: 3
 * world: 2
 * everyone: 1
 * This: 1
 * is: 1
 * a: 1
 * test: 1
 */
public class Task1 {
    public static void main(String[] args) {
        String sentence = "Hello, world! Hello everyone. This is a test. Hello world?";

        // TODO regex
        sentence = sentence.replace(",", "")
                .replace("!", "")
                .replaceAll("\\.", "")
                .replaceAll("\\?", "");

        List<String> listWords = new ArrayList<>(Arrays.asList(sentence.split(" ")));

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word: listWords) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // ����������� ���� � ������
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((v1, v2) -> v2.getValue().compareTo(v1.getValue()));

        // ������� ���������
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
