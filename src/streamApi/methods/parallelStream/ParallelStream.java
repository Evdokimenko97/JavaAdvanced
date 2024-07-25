package streamApi.methods.parallelStream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        double sumResult = list.parallelStream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("sumResult = " + sumResult);

        // Ответ: 8
        double divisionResult1 = list.stream().reduce((accumulator, element) -> accumulator/element).get();
        System.out.println("divisionResult1 = " + divisionResult1);

        // Ответ: 0.5
        double divisionResult2 = list.parallelStream().reduce((accumulator, element) -> accumulator/element).get();
        System.out.println("divisionResult2 = " + divisionResult2);
    }
}
