package streamApi.methods.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("Kak dela?");
        list.add("ok");
        list.add("poka");
        System.out.println("������ ������: " + list);

        List<Integer> list2 = list.stream()
                .map(element -> element.length())
                .collect(Collectors.toList());
        System.out.println("������ ������: " + list2);

        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array)
                .map(element -> {
                    if (element % 3 == 0) {
                        element = element / 3;
                    }
                    return element;
                }).toArray();
        System.out.println("������ ������: " + Arrays.toString(array));
    }
}
