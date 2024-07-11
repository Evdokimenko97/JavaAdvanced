package collection.Map.tasks;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ������: ������� ���������� ��������� ��������
 * �������� ��������� �� Java, ������� ��������� ������ ������ � ������������ ���������� ��������� �������� � ���� ������. ��������� ������ ������������ Map ��� �������� �������� � �� ����������.
 *
 * ����������:
 * ��������� ������ ��������� ������ ������.
 * ��������� ������ ���������� ���������� ��������� ������� ������� � ������.
 * ��������� ������ ������� ������ ������ � ��� ����������.
 * ������� ������ ���� ������������� � �������� (�� ���� 'A' � 'a' ��������� ������� ���������).
 *
 * ������ �����: "Hello, World!"
 * ������ ������: H: 1
 * e: 1
 * l: 3
 * o: 2
 * ,: 1
 *  : 1
 * W: 1
 * r: 1
 * d: 1
 * !: 1
 */
public class Task2 {
    public static void main(String[] args) {
        String sentence = "Hello, World!";

        char[] chars = sentence.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c: chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
