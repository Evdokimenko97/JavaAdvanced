package collection.List.tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * �������� �������
 * ��� ���������� ����������� ��������� �� Java, ������� ��������� ��������� �������� � ���������� List. ��������� ������ �������� � ����������������� ��������� � �������� �������������� �����������.
 *
 * �������� ������
 * �������� ����� Person � ������ name (���), age (�������) � city (�����). ����� ��������� ��������� ��������:
 *
 * �������� ������ �������� ���� Person.
 * �������� � ������ ��������� �������� Person.
 * ������� � �������� ���� ����� ������ 25 ���.
 * ������� �� ������ �����, ����������� � ������������ ������ (��������, "New York").
 * ������������ ������ �� �������� � �������� ��������������� ������.
 * �������� �����, ��������������� �� ������.
 * ������� � �������� �������� � ������������ ���������.
 * �������� ��� �������� ������.
 *
 */
public class Task4 {
    public static void main(String[] args) {
        // �������� ������ �������� ���� Person.
        // �������� � ������ ��������� �������� Person.
        List<Person> list = new ArrayList<>();
        list.add(new Person("Andrew", 18, "Moscow"));
        list.add(new Person("Vladimir", 28, "Uhta"));
        list.add(new Person("Denis", 22, "Orel"));
        list.add(new Person("Masha", 24, "New York"));
        list.add(new Person("Aleksandr", 30, "Saint-Petersburg"));

        // ������� � �������� ���� ����� ������ 25 ���.
        List<Person> personListMore25 = new ArrayList<>();
        for (Person person: list) {
            if(person.getAge() > 25) {
                personListMore25.add(person);
            }
        }
        System.out.println(personListMore25);

        // ������� �� ������ �����, ����������� � ������������ ������ (��������, "New York").
        list.removeIf(person -> person.getCity().equals("New York"));
        System.out.println(list);

        // ������������ ������ �� �������� � �������� ��������������� ������.
        list.sort(Comparator.comparingInt(Person::getAge));

        // �������� �����, ��������������� �� ������.
        System.out.println("����, ��������������� �� ������:");
        Map<String, List<Person>> groupedByCity = list.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        groupedByCity.forEach((city, persons) -> System.out.println(city + ": " + persons));

        // ������� � �������� �������� � ������������ ���������.
        System.out.println();
        list.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .ifPresent(System.out::println);

        // �������� ��� �������� ������.
        System.out.println();
        for (Person person: list) {
            System.out.println(person);
        }
    }
}

class Person {
    private final String name;
    private final int age;
    private final String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}