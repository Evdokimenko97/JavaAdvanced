package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class StudentInfo {
    void testStudents(ArrayList<Student> al, Predicate<Student> pr) {
        for (Student s : al) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(st1, st2, st3, st4, st5));

        // Пример сортировки через Comparator
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.course - s2.course;
//            }
//        });
//        System.out.println(students);

        // Пример сокращенной сортировки
//        Collections.sort(students, (s1, s2) -> s1.course - s2.course);
//        System.out.println(students);

        // Пример самой коротнкой сортировки
        students.sort(Comparator.comparing(s -> s.course));
        System.out.println(students);

        /**
         * Пример анонимного класса
         */
        StudentInfo info = new StudentInfo();
//        info.testStudents(students, new CheckOverGrade());
//        System.out.println("-------------");
//        info.testStudents(students, new StudentChecks() {
//            @Override
//            public boolean check(Student sc) {
//                return sc.age < 30;
//            }
//        });
//
//        // Лямбда
//        System.out.println("ЛЯМБДА-------------");
//        info.testStudents(students, (Student s) -> {
//            System.out.println("hello lambda!");
//            return s.age < 30;
//        });
//
//        System.out.println("-------------");
//        StudentChecks sc = s -> s.age < 30;
//        info.testStudents(students, sc);
//
        System.out.println("-------------");
        info.testStudents(students, (Student s) -> s.avgGrade > 8);
        System.out.println("-------------");
        info.testStudents(students, (Student s) -> s.age > 20 && s.avgGrade < 9.5 && s.sex == 'f');
    }
}

//interface StudentChecks {
//    boolean check(Student sc);
//}
//
//class CheckOverGrade implements StudentChecks {
//
//    @Override
//    public boolean check(Student sc) {
//        return sc.avgGrade > 8;
//    }
//}
