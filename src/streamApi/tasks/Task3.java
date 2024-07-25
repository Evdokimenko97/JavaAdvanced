package streamApi.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * �������
 * �������� ������
 * ��� ����� ����������� ������� ��� ���������� ������� ����������� � �� �������. ������� ������ �����:
 * <p>
 * ����������� ����������� �� ��������� ���������.
 * ��������������� ���������� � �����������.
 * ������������ ����������� �� ��������� ����������.
 * ����������� �����������.
 * ��������� ���������� �������� ��� ���������� �����������.
 * ����������
 * �������� ����� Employee � ������ name (��� ����������, ��� String), age (�������, ��� int), department (�����, ��� String) � salary (��������, ��� double).
 * <p>
 * �������� ������ ����������� � ��������������� ��� ����������� ������������ (��������, 10-15 �����������).
 * <p>
 * ������ �������������
 * ������������ ���� ����������� ������ 30 ���.
 * ������������ ������ ����������� � ������ �� ����.
 * ������������ ����������� �� �������.
 * ������������ ����������� �� ��������.
 * ��������� ������� �������� �� ������� ������.
 */
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Employee2> employees = new ArrayList<>();
        employees.add(new Employee2("������", 26, "����������", 280));
        employees.add(new Employee2("������", 28, "������������", 250));
        employees.add(new Employee2("���", 31, "������", 300));
        employees.add(new Employee2("�����", 34, "�������", 350));
        employees.add(new Employee2("������", 25, "����������", 240));
        employees.add(new Employee2("����", 29, "������������", 350));

        System.out.println("---������������ ���� ����������� ������ 30 ���.---");
        employees.stream().filter(employee -> employee.age > 30).forEach(System.out::println);
        System.out.println();

        System.out.println("---������������ ������ ����������� � ������ �� ����.---");
        List<String> employeeNames = employees.stream().map(employee -> employee.name).collect(Collectors.toList());
        System.out.println(employeeNames);
        System.out.println();

        System.out.println("---������������ ����������� �� �������.---");
        Map<String, List<Employee2>> mapDepartment = employees.stream().collect(Collectors.groupingBy(s -> s.department));
        mapDepartment.forEach((s, employee) -> System.out.println(s + " : " + employee));
        System.out.println();

        System.out.println("---������������ ����������� �� ��������.---");
        employees.stream().sorted(Comparator.comparingDouble(value -> value.salary)).forEach(System.out::println);
        System.out.println();

        System.out.println("---��������� ������� �������� �� ������� ������.---");
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
