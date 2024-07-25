package streamApi.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * �������
 * �������� ������
 * ��� ����� ����������� ������� ��� ���������� ������� ��������� � �� ������. ������� ������ �����:
 *
 * ����������� ��������� �� ��������� ���������.
 * ��������������� ���������� � ���������.
 * ��������� ���������� �������� ��� �������� ���������.
 * ����������
 * �������� ����� Student � ������ name (��� ��������, ��� String), age (�������, ��� int) � grade (������, ��� double).
 *
 * �������� ������ ��������� � ��������������� ��� ����������� ���������� (��������, 5-10 ���������).
 *
 * ���������� ��������� ������ � �������������� ����� � ����������� �� ������ java.util.function:
 *
 * filterStudents: �����, ������� ��������� ������ ��������� � �������� (Predicate<Student>) � ���������� ������ ���������, ��������������� ����� ���������.
 * mapStudents: �����, ������� ��������� ������ ��������� � ������� (Function<Student, R>) � ���������� ������ ����������� ���������� ������� � ������� ��������.
 * averageGrade: �����, ������� ��������� ������ ��������� � ���������� ������� ������ (double) ���� ���������.
 * ���������
 * ����������� Predicate<Student> ��� ����������.
 * ����������� Function<Student, R> ��� �������������� ���������� � ���������.
 * ����������� DoubleStream ��� Stream ��� ���������� ������� ������.
 * ������ �������������
 * ������������ ���� ��������� ������ 20 ���.
 * ������������ ������ ��������� � ������ �� ����.
 * ��������� ������� ������ ���� ���������.
 */
public class Task2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("������", 26, 7.0));
        students.add(new Student("����", 28, 8.0));
        students.add(new Student("����", 24, 6.5));
        students.add(new Student("����", 25, 9.1));
        students.add(new Student("����", 31, 7.2));
        students.add(new Student("������", 19, 8.4));

        System.out.println("---������������ ���� ��������� ������ 20 ���.---");
        students.stream().filter(student -> student.age > 20).forEach(System.out::println);
        System.out.println();

        System.out.println("---������������ ������ ��������� � ������ �� ����.---");
        List<String> studentNames = students.stream().map(student -> student.name).collect(Collectors.toList());
        System.out.println(studentNames);

        System.out.println("---��������� ������� ������ ���� ���������.---");
        OptionalDouble average = students.stream().mapToDouble(s -> s.grade).average();
        if (average.isPresent())
            System.out.println(average.getAsDouble());
    }
}

class Student {
    String name;
    int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
