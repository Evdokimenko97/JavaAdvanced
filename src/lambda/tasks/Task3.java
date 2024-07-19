package lambda.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Тестовое задание: Управление инвентарем
 * Задание:
 * Создай класс Product с полями id (тип int), name (тип String), price (тип double) и quantity (тип int).
 *
 * Создай список объектов типа Product.
 *
 * Используя функциональные интерфейсы из пакета java.util.function и лямбда-выражения, выполни следующие действия:
 *
 * Печать всех продуктов: Используй Consumer для печати каждого продукта в списке.
 * Фильтрация по цене: Используй Predicate для фильтрации списка продуктов с ценой выше заданного значения.
 * Получение списка имен продуктов: Используй Function для преобразования списка Product в список имен продуктов (List<String>).
 * Подсчет общей стоимости инвентаря: Используй Function для преобразования списка Product в общую стоимость всех продуктов (цена * количество).
 * Создание нового продукта: Используй Supplier для создания нового продукта.
 * Обновление цены продукта: Используй BiConsumer для обновления цены продукта на заданный процент.
 */
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Svekla", 100.2, 10));
        products.add(new Product(2, "Pomidor", 209.2, 150));
        products.add(new Product(3, "Kapusta", 35.2, 34));
        products.add(new Product(4, "Morkovka", 35.1, 62));

        System.out.println("----Печать всех продуктов----");
        products.forEach(System.out::println);
        System.out.println();

        System.out.println("---Фильтрация по цене----");
        List<Product> productFilterPrice = products.stream()
                .sorted(Comparator.comparingDouble(o -> o.price)).collect(Collectors.toList());
        productFilterPrice.forEach(System.out::println);
        System.out.println();

        System.out.println("----Получение списка имен продуктов----");
        Function<Product, String> fun = product -> product.name;
        List<String> productsName = products.stream()
                .map(fun)
                .collect(Collectors.toList());
        System.out.println(productsName);
        System.out.println();

        System.out.println("----Подсчет общей стоимости инвентаря----");
        double funPrice = products.stream()
                .mapToDouble(product -> product.price)
                .sum();
        System.out.println(funPrice);
        System.out.println();

        System.out.println("----Создание нового продукта----");
        Supplier<Product> supplier = () -> new Product(5, "Kartofel", 29.1, 33);
        products.add(supplier.get());
        products.forEach(System.out::println);
        System.out.println();

        System.out.println("----Обновление цены продукта----");
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
