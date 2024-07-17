package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class StudentInfo2 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(st1, st2, st3, st4, st5));

        StudentInfo2 info = new StudentInfo2();

        // Фильтрация по оценке больше 7.5 и мужской пол
        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';
        info.testStudents(students, p1.and(p2));
        System.out.println("---------------");
        info.testStudents(students, p1.negate());
    }

    void testStudents(ArrayList<Student> students, Predicate<Student> pr) {
        for (Student s: students) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }
}
