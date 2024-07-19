package lambda.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * �������� �������: ���������� ����������
 * �������:
 * ������ ����� Product � ������ id (��� int), name (��� String), price (��� double) � quantity (��� int).
 *
 * ������ ������ �������� ���� Product.
 *
 * ��������� �������������� ���������� �� ������ java.util.function � ������-���������, ������� ��������� ��������:
 *
 * ������ ���� ���������: ��������� Consumer ��� ������ ������� �������� � ������.
 * ���������� �� ����: ��������� Predicate ��� ���������� ������ ��������� � ����� ���� ��������� ��������.
 * ��������� ������ ���� ���������: ��������� Function ��� �������������� ������ Product � ������ ���� ��������� (List<String>).
 * ������� ����� ��������� ���������: ��������� Function ��� �������������� ������ Product � ����� ��������� ���� ��������� (���� * ����������).
 * �������� ������ ��������: ��������� Supplier ��� �������� ������ ��������.
 * ���������� ���� ��������: ��������� BiConsumer ��� ���������� ���� �������� �� �������� �������.
 */
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Svekla", 100.2, 10));
        products.add(new Product(2, "Pomidor", 209.2, 150));
        products.add(new Product(3, "Kapusta", 35.2, 34));
        products.add(new Product(4, "Morkovka", 35.1, 62));

        System.out.println("----������ ���� ���������----");
        products.forEach(System.out::println);
        System.out.println();

        System.out.println("---���������� �� ����----");
        List<Product> productFilterPrice = products.stream()
                .sorted(Comparator.comparingDouble(o -> o.price)).collect(Collectors.toList());
        productFilterPrice.forEach(System.out::println);
        System.out.println();

        System.out.println("----��������� ������ ���� ���������----");
        Function<Product, String> fun = product -> product.name;
        List<String> productsName = products.stream()
                .map(fun)
                .collect(Collectors.toList());
        System.out.println(productsName);
        System.out.println();

        System.out.println("----������� ����� ��������� ���������----");
        double funPrice = products.stream()
                .mapToDouble(product -> product.price)
                .sum();
        System.out.println(funPrice);
        System.out.println();

        System.out.println("----�������� ������ ��������----");
        Supplier<Product> supplier = () -> new Product(5, "Kartofel", 29.1, 33);
        products.add(supplier.get());
        products.forEach(System.out::println);
        System.out.println();

        System.out.println("----���������� ���� ��������----");
        BiConsumer<Product, Double> upDatingPrice = (product, percentage) -> product.price += product.price * percentage/100;
        products.forEach(product -> upDatingPrice.accept(product, 10.0));
        products.forEach(System.out::println);
    }
}

class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
