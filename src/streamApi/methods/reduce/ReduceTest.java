package streamApi.methods.reduce;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        // 5, 8, 2, 4, 3
        // accumulator = 5   40   80   320   960
        // element =     8    2    4     3
        int result = list.stream().reduce((accumulator, element) -> accumulator * element).get();
        System.out.println("Result: " + result);

//        Optional<Integer> o = list.stream().reduce((accumulator, element) -> accumulator * element);
//        if (o.isPresent()) {
//            System.out.println(o.get());
//        } else {
//            System.out.println("Not present");
//        }

        // 5, 8, 2, 4, 3
        // accumulator = 1    5   40    80   320   960
        // element =     5    8    2     4     3
        int result2 = list.stream().reduce(1, (accumulator, element) -> accumulator * element);
        System.out.println("Result 2: " + result2);

        List<String> list3 = new ArrayList<>();
        list3.add("privet");
        list3.add("Kak dela?");
        list3.add("ok");
        list3.add("poka");
        String result3 = list3.stream()
                .reduce((a, e) -> a + " " + e).get();
        System.out.println("Result 3: " + result3);
    }
}
