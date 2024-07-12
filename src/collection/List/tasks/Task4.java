package collection.List.tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Описание задания
 * Вам необходимо разработать программу на Java, которая выполняет различные операции с коллекцией List. Программа должна работать с пользовательскими объектами и включать дополнительные возможности.
 *
 * Описание задачи
 * Создайте класс Person с полями name (имя), age (возраст) и city (город). Затем выполните следующие действия:
 *
 * Создайте список объектов типа Person.
 * Добавьте в список несколько объектов Person.
 * Найдите и выведите всех людей старше 25 лет.
 * Удалите из списка людей, проживающих в определенном городе (например, "New York").
 * Отсортируйте список по возрасту и выведите отсортированный список.
 * Выведите людей, сгруппированных по городу.
 * Найдите и выведите человека с максимальным возрастом.
 * Выведите все элементы списка.
 *
 */
public class Task4 {
    public static void main(String[] args) {
        // Создайте список объектов типа Person.
        // Добавьте в список несколько объектов Person.
        List<Person> list = new ArrayList<>();
        list.add(new Person("Andrew", 18, "Moscow"));
        list.add(new Person("Vladimir", 28, "Uhta"));
        list.add(new Person("Denis", 22, "Orel"));
        list.add(new Person("Masha", 24, "New York"));
        list.add(new Person("Aleksandr", 30, "Saint-Petersburg"));

        // Найдите и выведите всех людей старше 25 лет.
        List<Person> personListMore25 = new ArrayList<>();
        for (Person person: list) {
            if(person.getAge() > 25) {
                personListMore25.add(person);
            }
        }
        System.out.println(personListMore25);

        // Удалите из списка людей, проживающих в определенном городе (например, "New York").
        list.removeIf(person -> person.getCity().equals("New York"));
        System.out.println(list);

        // Отсортируйте список по возрасту и выведите отсортированный список.
        list.sort(Comparator.comparingInt(Person::getAge));

        // Выведите людей, сгруппированных по городу.
        System.out.println("Люди, сгруппированные по городу:");
        Map<String, List<Person>> groupedByCity = list.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        groupedByCity.forEach((city, persons) -> System.out.println(city + ": " + persons));

        // Найдите и выведите человека с максимальным возрастом.
        System.out.println();
        list.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .ifPresent(System.out::println);

        // Выведите все элементы списка.
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