package streamApi.methods.mapToInt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 'm', 22, 3, 8.3));
        students.add(new Student("Nikolay", 'm', 28, 2, 6.4));
        students.add(new Student("Elena", 'f', 19, 1, 8.9));
        students.add(new Student("Petr", 'm', 35, 4, 7));
        students.add(new Student("Mariya", 'f', 23, 3, 7.4));

        List<Integer> courses = students.stream()
                .mapToInt(student -> student.getCourse())
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Все курсы: " + courses);

        int sum = students.stream().mapToInt(student -> student.getCourse()).sum();
        System.out.println("Сумма курсов: " + sum);

        double average = students.stream().mapToDouble(student -> student.getAvgGrade()).average().getAsDouble();
        System.out.println("Средняя оценка: " + average);

        int min = students.stream().mapToInt(student -> student.getCourse()).min().getAsInt();
        System.out.println("Минимальный курс: " + min);

        int max = students.stream().mapToInt(student -> student.getCourse()).max().getAsInt();
        System.out.println("Максимальный курс: " + max);
    }
}

class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}