package lambda.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Тестовое задание: Работа с функциональными интерфейсами
 * Задание:
 * Создай класс Person с полями name (тип String) и age (тип int).
 * <p>
 * Создай список объектов типа Person.
 * <p>
 * Используя функциональные интерфейсы из пакета java.util.function и лямбда-выражения, выполни следующие действия:
 * <p>
 * Печать всех объектов списка: Используй Consumer для печати каждого объекта в списке.
 * Фильтрация по возрасту: Используй Predicate для фильтрации списка людей старше определенного возраста.
 * Получение списка имен: Используй Function для преобразования списка Person в список имен (List<String>).
 * Создание объекта: Используй Supplier для создания нового объекта Person.
 */
public class Task1 {
    public static void main(String[] args) {
        Person person1 = new Person("Denis", 24);
        Person person2 = new Person("Andrew", 26);
        Person person3 = new Person("Vladimir", 23);
        Person person4 = new Person("Ivan", 34);
        Person person5 = new Person("Ksenia", 32);
        List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5));

        System.out.println("----Печать всех объектов списка----");
        Consumer<Person> personConsumer = System.out::println;
        people.forEach(personConsumer);
        System.out.println();

        System.out.println("----Фильтрация по возрасту----");
        Predicate<Person> predicate = person -> person.age >= 25;
        List<Person> adults = people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        adults.forEach(System.out::println);

        System.out.println("----Получение списка имен----");
        Function<Person, String> fun = person -> person.name;
        List<String> names = people.stream()
                .map(fun)
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("----Создание объекта----");
        Supplier<Person> supplier = () -> new Person("Drus", 44);
        Person newPerson = supplier.get();
        people.add(newPerson);
        System.out.println(people);
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
