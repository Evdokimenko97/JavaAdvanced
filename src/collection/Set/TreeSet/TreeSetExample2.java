package collection.Set.TreeSet;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetExample2 {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student st1 = new Student("Zaur", 3);
        Student st2 = new Student("Masha", 1);
        Student st3 = new Student("Dasha", 5);
        Student st4 = new Student("Oleg", 2);
        Student st5 = new Student("Igor", 5);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        System.out.println(treeSet);

        // ������ � ������
        System.out.println(treeSet.first());
        // ��������� � ������
        System.out.println(treeSet.last());

        // ����� ���������� (����� ����� �����)
        Student st6 = new Student("Olga", 5);
        System.out.println(treeSet.headSet(st6));

        // ����� ���������� (����� ����� ����� ��� �����)
        System.out.println(treeSet.tailSet(st6));

        // ����� ���������� (����� ������� ��� ����� (�� ������� �����))
        Student st7 = new Student("Ivan", 2);
        System.out.println(treeSet.subSet(st7, st6));

        System.out.println(st3.equals(st5));
    }
}

class Student implements Comparable<Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student student) {
        return this.course - student.course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }
}
