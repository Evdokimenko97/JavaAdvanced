package lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Тестовое задание: Управление библиотекой
 * Задание:
 * Создай класс Book с полями id (тип int), title (тип String), author (тип String), price (тип double), и quantity (тип int).
 *
 * Создай список объектов типа Book.
 *
 * Используя функциональные интерфейсы из пакета java.util.function и лямбда-выражения, выполни следующие действия:
 *
 * Печать всех книг: Используй Consumer для печати каждой книги в списке.
 * Фильтрация по автору: Используй Predicate для фильтрации списка книг по заданному автору.
 * Получение списка названий книг: Используй Function для преобразования списка Book в список названий книг (List<String>).
 * Подсчет общей стоимости всех книг: Используй Function для преобразования списка Book в общую стоимость всех книг (цена * количество).
 * Создание новой книги: Используй Supplier для создания новой книги.
 * Обновление количества книг: Используй BiConsumer для обновления количества книг на заданное значение.
 */
public class Task5 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Война и мир", "Толстой", 300.0, 10));
        books.add(new Book(2, "Братья Карамазовы", "Достоевский", 180.0, 12));
        books.add(new Book(3, "Отцы и дети", "Тургеньев", 127.5, 30));
        books.add(new Book(4, "12 стульев", "Ильф и Петров", 220, 13));
        books.add(new Book(5, "Мертвые души", "Гоголь", 100.0, 15));

        // Печать всех книг
        System.out.println("Печать всех книг");
        books.forEach(System.out::println);
        System.out.println();

        // Фильтрация по автору
        System.out.println("Фильтрация по автору");
        List<Book> booksAuthor = books.stream().filter(s -> s.author.equals("Толстой")).collect(Collectors.toList());
        booksAuthor.forEach(System.out::println);
        System.out.println();

        System.out.println("Получение списка названий книг");
        books.stream().map(s -> s.title).forEach(System.out::println);
        System.out.println();

        System.out.println("Подсчет общей стоимости всех книг");
        double sumPrice = books.stream().mapToDouble(s->s.price).sum();
        System.out.println("Общая сумма всех книг " + sumPrice);
        System.out.println();

        System.out.println("Создание новой книги");
        Supplier<Book> newBook = () -> new Book(6, "Я не такой как все", "Тинькоф", 777.7, 56);
        books.add(newBook.get());
        books.forEach(System.out::println);
        System.out.println();

        System.out.println("Обновление количества книг");
        BiConsumer<Book, Integer> consumer = (book, integer) -> book.quantity = book.quantity * integer;
        books.forEach(book -> consumer.accept(book,10));
        books.forEach(System.out::println);
    }
}

class Book {
    int id;
    String title;
    String author;
    double price;
    int quantity;

    public Book(int id, String title, String author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
