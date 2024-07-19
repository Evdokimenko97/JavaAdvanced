package lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Тестовое задание: Обработка списка заказов
 * Задание:
 * Создай класс Order с полями id (тип int), customerName (тип String), amount (тип double), и status (тип String, который может принимать значения "NEW", "PROCESSING", "COMPLETED", "CANCELLED").
 *
 * Создай список объектов типа Order.
 *
 * Используя функциональные интерфейсы из пакета java.util.function и лямбда-выражения, выполни следующие действия:
 *
 * Печать всех заказов: Используй Consumer для печати каждого заказа в списке.
 * Фильтрация по статусу заказа: Используй Predicate для фильтрации списка заказов со статусом "COMPLETED".
 * Получение списка имен клиентов: Используй Function для преобразования списка Order в список имен клиентов (List<String>).
 * Подсчет общей суммы заказов по статусу: Используй Function для преобразования списка Order в общую сумму заказов по заданному статусу.
 * Создание нового заказа: Используй Supplier для создания нового заказа.
 * Обновление статуса заказа: Используй BiConsumer для обновления статуса заказа.
 */
public class Task4 {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Dima", 2.1, "NEW"));
        orders.add(new Order(2, "Misha", 4.5, "PROCESSING"));
        orders.add(new Order(3, "Andrew", 3.4, "NEW"));
        orders.add(new Order(4, "Zina", 1.2, "COMPLETED"));
        orders.add(new Order(5, "Egor", 2.1, "CANCELLED"));

        System.out.println("----Печать всех заказов----");
        orders.forEach(System.out::println);
        System.out.println();

        System.out.println("----Фильтрация по статусу заказа----");
        orders.stream()
                .filter(order -> order.customerName.equals("COMPLETED"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("----Получение списка имен клиентов----");
        List<String> nameList = orders.stream()
                .map(order -> order.customerName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
        System.out.println();

        System.out.println("----Подсчет общей суммы заказов по статусу----");
        double sumPrice = orders.stream()
                .mapToDouble(order -> order.amount)
                .sum();
        System.out.println(sumPrice);
        System.out.println();

        System.out.println("----Создание нового заказа----");
        Supplier<Order> supplier = () -> new Order(6, "Semen", 6.6, "NEW");
        orders.add(supplier.get());
        orders.forEach(System.out::println);
        System.out.println();

        System.out.println("---Обновление статуса заказа----");
        BiConsumer<Order, Integer> updatingPrice = (order, s) -> order.amount += order.amount * s/ 100;
        orders.forEach(order -> updatingPrice.accept(order, 10));
        orders.forEach(System.out::println);
    }
}

class Order {
    int id;
    String customerName;
    double amount;
    String status;

    public Order(int id, String customerName, double amount, String status) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
