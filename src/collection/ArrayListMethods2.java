package collection;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListMethods2 {
    public static void main(String[] args) {
        Student st1 = new Student("Misha", 'm', 10);
        Student st2 = new Student("Masha", 'w', 12);
        Student st3 = new Student("Grisha", 'm', 8);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        System.out.println(students);

        // Метод remove не удаляет объект из-за того, что он работает по ссылкам. Нужно переопределять equals
        // Переопределив equals мы получим сравнение именно объектов
        Student st4 = new Student("Grisha", 'm', 8);
        students.remove(st4);
        System.out.println(students);
    }
}

class Student {
    private String name;

    private char sex;
    private int age;

    public Student(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex && age == student.age && Objects.equals(name, student.name);
    }
}
