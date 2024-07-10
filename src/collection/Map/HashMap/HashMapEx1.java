package collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000, "Zaur Tregulov");
        map1.put(3568, "Ivan Ivanov");
        map1.put(2271, "Marya Sidorova");
        map1.put(5519, "Nikolay Petrov"); // ����, ���� ����� ����������
        map1.putIfAbsent(5519, "Andrew Evdokimenko"); // ����, ���� ���� ����� �� ����
        map1.put(null, "Druss");
        map1.put(3241, null);

        // get
        System.out.println(map1);
        System.out.println(map1.get(1000));

        // remove
        map1.remove(1000);
        System.out.println(map1);

        // containsValue
        // containsKey
        System.out.println(map1.containsValue("Zaur Tregulov"));
        System.out.println(map1.containsKey(1000));

        // keySet() - ��-�� ���� ������
        System.out.println(map1.keySet());

        // keySet() - ��-�� ���� ��������
        System.out.println(map1.values());
    }
}
