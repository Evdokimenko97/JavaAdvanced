package collection.Map.tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * �������: ��������� ������ �����������
 * �������� ������ Employee:
 *
 * ����:
 * int id
 * String name
 * String department
 * double salary
 * int age
 * ������������, �������, �������, ������ toString, equals, hashCode
 *
 * �������� ������ �����������:
 * �������� List<Employee> � �������� � ���� ������� 10 ����������� � ���������� ���������� �����.
 *
 * ���������� �����������:
 * ������������ ������ ����������� �� �����.
 * ������������ ������ ����������� �� �������� � ������� ��������.
 *
 * ���������� � ������ � �����:
 * ������������ ����������� ������ 30 ��� � �������� �� � Map<Integer, Employee>, ��� ���� - ��� id ����������.
 *
 * ����������� �����������:
 * ������������ ����������� �� ������������� (department) � �������� ���������.
 *
 * ����� ���������� � ������������ ���������:
 * ������� ���������� � ������������ ���������.
 *
 * ������� �������� �� �������������:
 * ����������� ������� �������� ��� ������� ������������.
 *
 * �������� �������:
 * ���������, ��� �� ���������� ������ 25 ���.
 * ���� �� ���� �� ���� ��������� � ��������� ������ 100000.
 *
 * �������������� ������:
 * �������� ����� ������, ���������� ������ ����� �����������.
 *
 * �������������� �������:
 * �������� �����, ������� ��������� ������ ����������� � ���������� �����, ��� ���� - �������, � �������� - ���������� ����������� ����� ��������.
 */
public class Task4 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "������", "����������", 280, 26));
        employees.add(new Employee(2, "������", "������������", 250, 31));
        employees.add(new Employee(3, "���", "������", 300, 34));
        employees.add(new Employee(4,"�����", "�������", 350, 29));
        employees.add(new Employee(5, "������", "����������", 240, 25));
        employees.add(new Employee(6, "����", "������������", 350, 29));
        employees.add(new Employee(7, "����", "������", 290, 29));
        employees.add(new Employee(7, "������", "����������", 260, 28));

        System.out.println("������������ ������ ����������� �� �����");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("������������ ������ ����������� �� �������� � ������� ��������.");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .forEach(System.out::println);
        System.out.println();

        System.out.println("������������ ����������� ������ 30 ��� � �������� �� � Map<Integer, Employee>, ��� ���� - ��� id ����������.");
        employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toMap(Employee::getId, employee -> employee))
                .forEach((integer, employee) -> System.out.println(integer + " : " + employee));
        System.out.println();

        System.out.println("������������ ����������� �� ������������� (department) � �������� ���������.");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                .forEach((s, employees1) -> System.out.println(s + ":" + employees1));
        System.out.println();

        System.out.println("������� ���������� � ������������ ���������.");
        double maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary).max().getAsDouble();
        System.out.println(maxSalary);
        System.out.println();

        System.out.println("����������� ������� �������� ��� ������� ������������.");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((s, aDouble) -> System.out.println(s + ":" + aDouble));
        System.out.println();

        System.out.println("���������, ��� �� ���������� ������ 25 ���.");
        boolean comparAge = employees.stream()
                .allMatch(employee -> employee.getAge() > 25);
        System.out.println(comparAge);
        System.out.println();

        System.out.println("���� �� ���� �� ���� ��������� � ��������� ������ 100000.");
        boolean isSal = employees.stream()
                .anyMatch(employee -> employee.getSalary() > 100.0);
        System.out.println(isSal);
        System.out.println();

        System.out.println("�������� ����� ������, ���������� ������ ����� �����������.");
        List<String> listNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(listNames);
        System.out.println();

        System.out.println("�������� �����, ������� ��������� ������ ����������� � ���������� �����, ��� ���� - �������, � �������� - ���������� ����������� ����� ��������.");
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