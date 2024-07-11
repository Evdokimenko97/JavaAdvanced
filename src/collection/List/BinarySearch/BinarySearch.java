package collection.List.BinarySearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-3, 8, 12, -8, 0, 5, 10, 1 , 150, -30, 19));
        Collections.sort(arrayList);
        int index1 = Collections.binarySearch(arrayList, 12);
        System.out.println(index1);

        Student st1 = new Student(100, "Zaur", 10000);
        Student st2 = new Student(15, "Ivan", 12000);
        Student st3 = new Student(123, "Petr", 8000);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        System.out.println(students);

        // Сортировка коллекции
        Collections.sort(students);
        System.out.println(students);

        // Поиск по binarySearch
        int index2 = Collections.binarySearch(students, new Student(123, "Petr", 8000));
        System.out.println(index2);

        // Бинарный поиск через Arrays
        int[] array = {-3, 8, 12, -8, 0, 5, 10, 1 , 150, -30, 19};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int index3 = Arrays.binarySearch(array, 150);
        System.out.println(index3);

        // Перевернутый список
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        // Перемешиваем список
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }
}

class Student implements Comparable<Student> {
    private int id;

    private String name;
    private int salary;

    public Student(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", salary=" + salary +
                '}';

    }

    @Override
    public int compareTo(Student another) {
        int result = this.id - another.id;

        if (result == 0) {
            result = this.name.compareTo(another.name);
        }

        return result;
    }
}
