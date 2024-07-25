package streamApi.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Задание
 * Описание задачи
 * Вам нужно разработать систему для управления списком студентов и их оценок. Система должна уметь:
 *
 * Фильтровать студентов по различным критериям.
 * Преобразовывать информацию о студентах.
 * Выполнять агрегатные операции над оценками студентов.
 * Требования
 * Создайте класс Student с полями name (имя студента, тип String), age (возраст, тип int) и grade (оценка, тип double).
 *
 * Создайте список студентов и инициализируйте его несколькими студентами (например, 5-10 студентов).
 *
 * Реализуйте следующие методы с использованием лямбд и интерфейсов из пакета java.util.function:
 *
 * filterStudents: Метод, который принимает список студентов и предикат (Predicate<Student>) и возвращает список студентов, соответствующих этому предикату.
 * mapStudents: Метод, который принимает список студентов и функцию (Function<Student, R>) и возвращает список результатов применения функции к каждому студенту.
 * averageGrade: Метод, который принимает список студентов и возвращает среднюю оценку (double) всех студентов.
 * Подсказки
 * Используйте Predicate<Student> для фильтрации.
 * Используйте Function<Student, R> для преобразования информации о студентах.
 * Используйте DoubleStream или Stream для вычисления средней оценки.
 * Пример использования
 * Отфильтруйте всех студентов старше 20 лет.
 * Преобразуйте список студентов в список их имен.
 * Вычислите среднюю оценку всех студентов.
 */
public class Task2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Андрей", 26, 7.0));
        students.add(new Student("Вася", 28, 8.0));
        students.add(new Student("Петя", 24, 6.5));
        students.add(new Student("Маша", 25, 9.1));
        students.add(new Student("Лиза", 31, 7.2));
        students.add(new Student("Сергей", 19, 8.4));

        System.out.println("---Отфильтруйте всех студентов старше 20 лет.---");
        students.stream().filter(student -> student.age > 20).forEach(System.out::println);
        System.out.println();

        System.out.println("---Преобразуйте список студентов в список их имен.---");
        List<String> studentNames = students.stream().map(student -> student.name).collect(Collectors.toList());
        System.out.println(studentNames);

        System.out.println("---Вычислите среднюю оценку всех студентов.---");
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
