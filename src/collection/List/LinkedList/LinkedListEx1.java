package collection.List.LinkedList;

import java.util.LinkedList;

public class LinkedListEx1 {
    public static void main(String[] args) {
        Student st1 = new Student("Misha", 10);
        Student st2 = new Student("Masha", 12);
        Student st3 = new Student("Grisha", 8);

        LinkedList<Student> students = new LinkedList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        System.out.println(students);

        Student st4 = new Student("Dima", 5);
        students.add(2, st4);
        System.out.println(students);
    }
}

class Student {
    private final String name;

    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
