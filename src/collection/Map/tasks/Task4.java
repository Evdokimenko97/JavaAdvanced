package collection.Map.tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Задание: Обработка списка сотрудников
 * Создание класса Employee:
 *
 * Поля:
 * int id
 * String name
 * String department
 * double salary
 * int age
 * Конструкторы, геттеры, сеттеры, методы toString, equals, hashCode
 *
 * Создание списка сотрудников:
 * Создайте List<Employee> и добавьте в него минимум 10 сотрудников с различными значениями полей.
 *
 * Сортировка сотрудников:
 * Отсортируйте список сотрудников по имени.
 * Отсортируйте список сотрудников по зарплате в порядке убывания.
 *
 * Фильтрация и сборка в карту:
 * Отфильтруйте сотрудников старше 30 лет и соберите их в Map<Integer, Employee>, где ключ - это id сотрудника.
 *
 * Группировка сотрудников:
 * Сгруппируйте сотрудников по департаментам (department) и выведите результат.
 *
 * Поиск сотрудника с максимальной зарплатой:
 * Найдите сотрудника с максимальной зарплатой.
 *
 * Средняя зарплата по департаментам:
 * Рассчитайте среднюю зарплату для каждого департамента.
 *
 * Проверка условий:
 * Проверьте, все ли сотрудники старше 25 лет.
 * Есть ли хотя бы один сотрудник с зарплатой больше 100000.
 *
 * Преобразование списка:
 * Создайте новый список, содержащий только имена сотрудников.
 *
 * Дополнительное задание:
 * Создайте метод, который принимает список сотрудников и возвращает карту, где ключ - возраст, а значение - количество сотрудников этого возраста.
 */
public class Task4 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Фредди", "Разработка", 280, 26));
        employees.add(new Employee(2, "Джусси", "Тестирование", 250, 31));
        employees.add(new Employee(3, "Кен", "Девопс", 300, 34));
        employees.add(new Employee(4,"Салли", "Манагер", 350, 29));
        employees.add(new Employee(5, "Тифони", "Разработка", 240, 25));
        employees.add(new Employee(6, "Дени", "Тестирование", 350, 29));
        employees.add(new Employee(7, "Крис", "Девопс", 290, 29));
        employees.add(new Employee(7, "Моника", "Разработка", 260, 28));

        System.out.println("Отсортируйте список сотрудников по имени");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Отсортируйте список сотрудников по зарплате в порядке убывания.");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .forEach(System.out::println);
        System.out.println();

        System.out.println("Отфильтруйте сотрудников старше 30 лет и соберите их в Map<Integer, Employee>, где ключ - это id сотрудника.");
        employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toMap(Employee::getId, employee -> employee))
                .forEach((integer, employee) -> System.out.println(integer + " : " + employee));
        System.out.println();

        System.out.println("Сгруппируйте сотрудников по департаментам (department) и выведите результат.");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                .forEach((s, employees1) -> System.out.println(s + ":" + employees1));
        System.out.println();

        System.out.println("Найдите сотрудника с максимальной зарплатой.");
        double maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary).max().getAsDouble();
        System.out.println(maxSalary);
        System.out.println();

        System.out.println("Рассчитайте среднюю зарплату для каждого департамента.");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((s, aDouble) -> System.out.println(s + ":" + aDouble));
        System.out.println();

        System.out.println("Проверьте, все ли сотрудники старше 25 лет.");
        boolean comparAge = employees.stream()
                .allMatch(employee -> employee.getAge() > 25);
        System.out.println(comparAge);
        System.out.println();

        System.out.println("Есть ли хотя бы один сотрудник с зарплатой больше 100000.");
        boolean isSal = employees.stream()
                .anyMatch(employee -> employee.getSalary() > 100.0);
        System.out.println(isSal);
        System.out.println();

        System.out.println("Создайте новый список, содержащий только имена сотрудников.");
        List<String> listNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(listNames);
        System.out.println();

        System.out.println("Создайте метод, который принимает список сотрудников и возвращает карту, где ключ - возраст, а значение - количество сотрудников этого возраста.");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()))
                .forEach((integer, counter) -> System.out.println(integer + ":" +  counter));
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary, age);
    }
}