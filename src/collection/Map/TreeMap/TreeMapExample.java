package collection.Map.TreeMap;

import collection.Map.HashMap.Student;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Marya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Igorevich", 5);
        Student st5 = new Student("Vasilyi", "Vasilievich", 1);

        // ������ put
        treeMap.put(5.8, st1);
        treeMap.put(9.3, st2);
        treeMap.put(7.2, st3);
        treeMap.put(8.7, st4);
        treeMap.put(7.9, st5);

        System.out.println(treeMap);

        // ����� get
        System.out.println(treeMap.get(5.8));

        // ����� remove
        System.out.println(treeMap.remove(5.8));
        System.out.println(treeMap.get(5.8));

        // ����� ���������� �� �������� descendingMap()
        System.out.println(treeMap.descendingMap());

        // �������� ���� (�� �����������)
        System.out.println(treeMap.tailMap(7.3));

        // �������� ���� (�� ��������)
        System.out.println(treeMap.headMap(7.3));

        // ����� ������� ������� �� �����
        System.out.println(treeMap.lastEntry());
    }
}
