package lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * �������� �������: ���������� �����������
 * �������:
 * ������ ����� Book � ������ id (��� int), title (��� String), author (��� String), price (��� double), � quantity (��� int).
 *
 * ������ ������ �������� ���� Book.
 *
 * ��������� �������������� ���������� �� ������ java.util.function � ������-���������, ������� ��������� ��������:
 *
 * ������ ���� ����: ��������� Consumer ��� ������ ������ ����� � ������.
 * ���������� �� ������: ��������� Predicate ��� ���������� ������ ���� �� ��������� ������.
 * ��������� ������ �������� ����: ��������� Function ��� �������������� ������ Book � ������ �������� ���� (List<String>).
 * ������� ����� ��������� ���� ����: ��������� Function ��� �������������� ������ Book � ����� ��������� ���� ���� (���� * ����������).
 * �������� ����� �����: ��������� Supplier ��� �������� ����� �����.
 * ���������� ���������� ����: ��������� BiConsumer ��� ���������� ���������� ���� �� �������� ��������.
 */
public class Task5 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "����� � ���", "�������", 300.0, 10));
        books.add(new Book(2, "������ ����������", "�����������", 180.0, 12));
        books.add(new Book(3, "���� � ����", "���������", 127.5, 30));
        books.add(new Book(4, "12 �������", "���� � ������", 220, 13));
        books.add(new Book(5, "������� ����", "������", 100.0, 15));

        // ������ ���� ����
        System.out.println("������ ���� ����");
        books.forEach(System.out::println);
        System.out.println();

        // ���������� �� ������
        System.out.println("���������� �� ������");
        List<Book> booksAuthor = books.stream().filter(s -> s.author.equals("�������")).collect(Collectors.toList());
        booksAuthor.forEach(System.out::println);
        System.out.println();

        System.out.println("��������� ������ �������� ����");
        books.stream().map(s -> s.title).forEach(System.out::println);
        System.out.println();

        System.out.println("������� ����� ��������� ���� ����");
        double sumPrice = books.stream().mapToDouble(s->s.price).sum();
        System.out.println("����� ����� ���� ���� " + sumPrice);
        System.out.println();

        System.out.println("�������� ����� �����");
        Supplier<Book> newBook = () -> new Book(6, "� �� ����� ��� ���", "�������", 777.7, 56);
        books.add(newBook.get());
        books.forEach(System.out::println);
        System.out.println();

        System.out.println("���������� ���������� ����");
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
