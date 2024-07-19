package lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * �������� �������: ��������� ������ �������
 * �������:
 * ������ ����� Order � ������ id (��� int), customerName (��� String), amount (��� double), � status (��� String, ������� ����� ��������� �������� "NEW", "PROCESSING", "COMPLETED", "CANCELLED").
 *
 * ������ ������ �������� ���� Order.
 *
 * ��������� �������������� ���������� �� ������ java.util.function � ������-���������, ������� ��������� ��������:
 *
 * ������ ���� �������: ��������� Consumer ��� ������ ������� ������ � ������.
 * ���������� �� ������� ������: ��������� Predicate ��� ���������� ������ ������� �� �������� "COMPLETED".
 * ��������� ������ ���� ��������: ��������� Function ��� �������������� ������ Order � ������ ���� �������� (List<String>).
 * ������� ����� ����� ������� �� �������: ��������� Function ��� �������������� ������ Order � ����� ����� ������� �� ��������� �������.
 * �������� ������ ������: ��������� Supplier ��� �������� ������ ������.
 * ���������� ������� ������: ��������� BiConsumer ��� ���������� ������� ������.
 */
public class Task4 {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Dima", 2.1, "NEW"));
        orders.add(new Order(2, "Misha", 4.5, "PROCESSING"));
        orders.add(new Order(3, "Andrew", 3.4, "NEW"));
        orders.add(new Order(4, "Zina", 1.2, "COMPLETED"));
        orders.add(new Order(5, "Egor", 2.1, "CANCELLED"));

        System.out.println("----������ ���� �������----");
        orders.forEach(System.out::println);
        System.out.println();

        System.out.println("----���������� �� ������� ������----");
        orders.stream()
                .filter(order -> order.customerName.equals("COMPLETED"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("----��������� ������ ���� ��������----");
        List<String> nameList = orders.stream()
                .map(order -> order.customerName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
        System.out.println();

        System.out.println("----������� ����� ����� ������� �� �������----");
        double sumPrice = orders.stream()
                .mapToDouble(order -> order.amount)
                .sum();
        System.out.println(sumPrice);
        System.out.println();

        System.out.println("----�������� ������ ������----");
        Supplier<Order> supplier = () -> new Order(6, "Semen", 6.6, "NEW");
        orders.add(supplier.get());
        orders.forEach(System.out::println);
        System.out.println();

        System.out.println("---���������� ������� ������----");
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
