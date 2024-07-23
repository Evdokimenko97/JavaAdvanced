package streamApi.tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * �������� �������: ���������� ������������
 * �������:
 * ������ ����� Employee � ������ id (��� int), name (��� String), age (��� int), department (��� String), salary (��� double).
 *
 * ������ ������ �������� ���� Employee.
 *
 * ��������� Stream API, ������� ��������� ��������:
 *
 * ������ ���� �����������: ����� � ��������� ���� �����������.
 * ���������� ����������� �� ��������: ����� � ��������� ���� ����������� ������ ��������� ��������.
 * ������� ������� �������� �� �������: ��������� ������� �������� ����������� ��� ������� ������.
 * ����� ���������� � ������������ ���������: ����� � ��������� ���������� � ����� ������� ���������.
 * ������� ���������� ����������� � ������ ������: ��������� ���������� ����������� � ������ ������.
 * ��������� ������ ���������� ���� �����������: ������ � ��������� ������ ���� ���������� ���� �����������.
 * ����������� ����������� �� �������: ���������� ����������� �� ������� � ��������� ���������.
 * ���������� ����������� �� ��������: ���������� ����������� �� �������� � ������� �������� � ��������� ���������.
 * ��������� ����� ���������� � ���������� ��������� � ������ ������: ��� ������� ������ ����� ��� ���������� � ���������� ���������.
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

        System.out.println("������ ���� �����������");
        employees.forEach(System.out::println);
        System.out.println();

        System.out.println("���������� ����������� �� ��������");
        employees.stream().filter(e -> e.age > 28).forEach(System.out::println);
        System.out.println();

        System.out.println("������� ������� �������� �� �������");
        Map<String, Double> averageSalaryPerDept = employees.stream().collect(Collectors.groupingBy(employee -> employee.department, Collectors.averagingDouble(employee -> employee.salary)));
        averageSalaryPerDept.forEach((dept, avgSalary) -> System.out.println(dept + ":" + avgSalary));
        System.out.println();

        System.out.println("����� ���������� � ������������ ���������");
        List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparing(employee -> employee.salary)).collect(Collectors.toList());
        System.out.println(sortedEmployees.get(sortedEmployees.size()-1));
        System.out.println();

        System.out.println("������� ���������� ����������� � ������ ������");
        Map<String, List<Employee>> countEmployeesInDepartment = employees.stream().collect(Collectors.groupingBy(employee -> employee.department));
        for (Map.Entry<String, List<Employee>> entry: countEmployeesInDepartment.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().size());
        }
        System.out.println();

        System.out.println("��������� ������ ���������� ���� �����������");
        employees.stream().map(employee -> employee.name).distinct().forEach(System.out::println);
        System.out.println();

        System.out.println("����������� ����������� �� �������");
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.department));
        for (Map.Entry<String, List<Employee>> entry: collect.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println();

        System.out.println("���������� ����������� �� ��������");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
        System.out.println();

        System.out.println("��������� ����� ���������� � ���������� ��������� � ������ ������");
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
