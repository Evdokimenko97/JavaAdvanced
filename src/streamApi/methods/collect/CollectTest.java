package streamApi.methods.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 'm', 22, 3, 8.3));
        students.add(new Student("Nikolay", 'm', 28, 2, 6.4));
        students.add(new Student("Elena", 'f', 19, 1, 8.9));
        students.add(new Student("Petr", 'm', 35, 4, 7));
        students.add(new Student("Mariya", 'f', 23, 3, 7.4));

        Map<Integer, List<Student>> collect1 = students.stream()
                .map(e1 -> {
                    e1.setName(e1.getName().toUpperCase(Locale.ROOT));
                    return e1;
                }).collect(Collectors.groupingBy(course -> course.getCourse()));

        for (Map.Entry<Integer, List<Student>> entry: collect1.entrySet()) {
            System.out.println(entry.getKey() + " курс: " + entry.getValue());
        }

        Map<Boolean, List<Student>> collect2 = students.stream()
                .collect(Collectors.partitioningBy(e1 -> e1.getAvgGrade() > 7));

        for (Map.Entry<Boolean, List<Student>> entry: collect2.entrySet()) {
            System.out.println(entry.getKey() + " 7 баллов: " + entry.getValue());
        }
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
