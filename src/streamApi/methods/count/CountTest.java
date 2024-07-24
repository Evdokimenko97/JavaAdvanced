package streamApi.methods.count;

import java.util.stream.Stream;

public class CountTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        long count = stream.count();
        System.out.println(count);
    }
}
