package streamApi.tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Тестовое задание: Управление сотрудниками
 * Задание:
 * Создай класс Employee с полями id (тип int), name (тип String), age (тип int), department (тип String), salary (тип double).
 *
 * Создай список объектов типа Employee.
 *
 * Используя Stream API, выполни следующие действия:
 *
 * Печать всех сотрудников: Найди и напечатай всех сотрудников.
 * Фильтрация сотрудников по возрасту: Найди и напечатай всех сотрудников старше заданного возраста.
 * Подсчет средней зарплаты по отделам: Подсчитай среднюю зарплату сотрудников для каждого отдела.
 * Поиск сотрудника с максимальной зарплатой: Найди и напечатай сотрудника с самой высокой зарплатой.
 * Подсчет количества сотрудников в каждом отделе: Подсчитай количество сотрудников в каждом отделе.
 * Получение списка уникальных имен сотрудников: Получи и напечатай список всех уникальных имен сотрудников.
 * Группировка сотрудников по отделам: Сгруппируй сотрудников по отделам и напечатай результат.
 * Сортировка сотрудников по зарплате: Отсортируй сотрудников по зарплате в порядке убывания и напечатай результат.
 * Получение имени сотрудника с наибольшей зарплатой в каждом отделе: Для каждого отдела найди имя сотрудника с наибольшей зарплатой.
 */
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ivan", 32, "A", 320));
        employees.add(new Employee(2, "Denis", 28, "A", 240));
        employees.add(new Employee(3, "Mariya", 25, "B", 280));
        employees.add(new Employee(4, "Ksusha", 28, "B", 250));
        employees.add(new Employee(5, "Andrey", 26, "C", 260));
        employees.add(new Employee(6, "Mihail", 29, "C", 270));
        employees.add(new Employee(7, "Mihail", 29, "C", 270));

        System.out.println("Печать всех сотрудников");
        employees.forEach(System.out::println);
        System.out.println();

        System.out.println("Фильтрация сотрудников по возрасту");
        employees.stream().filter(e -> e.age > 28).forEach(System.out::println);
        System.out.println();

        System.out.println("Подсчет средней зарплаты по отделам");
        Map<String, Double> averageSalaryPerDept = employees.stream().collect(Collectors.groupingBy(employee -> employee.department, Collectors.averagingDouble(employee -> employee.salary)));
        averageSalaryPerDept.forEach((dept, avgSalary) -> System.out.println(dept + ":" + avgSalary));
        System.out.println();

        System.out.println("Поиск сотрудника с максимальной зарплатой");
        List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(employee -> employee.salary)).collect(Collectors.toList());
        System.out.println(sortedEmployees.get(sortedEmployees.size()-1));
        System.out.println();

        System.out.println("Подсчет количества сотрудников в каждом отделе");
        Map<String, List<Employee>> countEmployeesInDepartment = employees.stream().collect(Collectors.groupingBy(employee -> employee.department));
        for (Map.Entry<String, List<Employee>> entry: countEmployeesInDepartment.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().size());
        }
        System.out.println();

        System.out.println("Получение списка уникальных имен сотрудников");
        employees.stream().map(employee -> employee.name).distinct().forEach(System.out::println);
        System.out.println();

        System.out.println("Группировка сотрудников по отделам");
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.department));
        for (Map.Entry<String, List<Employee>> entry: collect.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println();

        System.out.println("Сортировка сотрудников по зарплате");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
        System.out.println();

        System.out.println("Получение имени сотрудника с наибольшей зарплатой в каждом отделе");
        employees.stream().collect(Collectors.groupingBy(employee -> employee.department,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))).forEach((s, employee) -> System.out.println(s + ":" + employee.get().salary));
    }
}

class Employee {
    int id;
    String name;
    int age;
    String department;
    double salary;

    public Employee(int id, String name, int age, String department, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
