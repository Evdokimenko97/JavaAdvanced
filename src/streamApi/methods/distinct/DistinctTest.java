package streamApi.methods.distinct;

import java.util.stream.Stream;

public class DistinctTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        stream.distinct().forEach(System.out::println);
    }
}
