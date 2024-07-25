package streamApi.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Задание
 * Описание задачи
 * Вам нужно разработать систему для управления списком сотрудников и их зарплат. Система должна уметь:
 * <p>
 * Фильтровать сотрудников по различным критериям.
 * Преобразовывать информацию о сотрудниках.
 * Группировать сотрудников по различным параметрам.
 * Сортировать сотрудников.
 * Выполнять агрегатные операции над зарплатами сотрудников.
 * Требования
 * Создайте класс Employee с полями name (имя сотрудника, тип String), age (возраст, тип int), department (отдел, тип String) и salary (зарплата, тип double).
 * <p>
 * Создайте список сотрудников и инициализируйте его несколькими сотрудниками (например, 10-15 сотрудников).
 * <p>
 * Пример использования
 * Отфильтруйте всех сотрудников старше 30 лет.
 * Преобразуйте список сотрудников в список их имен.
 * Сгруппируйте сотрудников по отделам.
 * Отсортируйте сотрудников по зарплате.
 * Вычислите среднюю зарплату по каждому отделу.
 */
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Employee2> employees = new ArrayList<>();
        employees.add(new Employee2("Фредди", 26, "Разработка", 280));
        employees.add(new Employee2("Джусси", 28, "Тестирование", 250));
        employees.add(new Employee2("Кен", 31, "Девопс", 300));
        employees.add(new Employee2("Салли", 34, "Манагер", 350));
        employees.add(new Employee2("Тифони", 25, "Разработка", 240));
        employees.add(new Employee2("Дени", 29, "Тестирование", 350));

        System.out.println("---Отфильтруйте всех сотрудников старше 30 лет.---");
        employees.stream().filter(employee -> employee.age > 30).forEach(System.out::println);
        System.out.println();

        System.out.println("---Преобразуйте список сотрудников в список их имен.---");
        List<String> employeeNames = employees.stream().map(employee -> employee.name).collect(Collectors.toList());
        System.out.println(employeeNames);
        System.out.println();

        System.out.println("---Сгруппируйте сотрудников по отделам.---");
        Map<String, List<Employee2>> mapDepartment = employees.stream().collect(Collectors.groupingBy(s -> s.department));
        mapDepartment.forEach((s, employee) -> System.out.println(s + " : " + employee));
        System.out.println();

        System.out.println("---Отсортируйте сотрудников по зарплате.---");
        employees.stream().sorted(Comparator.comparingDouble(value -> value.salary)).forEach(System.out::println);
        System.out.println();

        System.out.println("---Вычислите среднюю зарплату по каждому отделу.---");
        employees.stream()
                .collect(Collectors.groupingBy(s -> s.department, Collectors.averagingDouble(sal -> sal.salary)))
                .forEach((s, aDouble) -> System.out.println(s + ": " + aDouble));
    }
}

class Employee2 {
    String name;
    int age;
    String department;
    double salary;

    public Employee2(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
