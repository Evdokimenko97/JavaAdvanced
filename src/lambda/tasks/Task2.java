package lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Тестовое задание: Анализ данных с использованием функциональных интерфейсов
 * Задание:
 * Создай класс Transaction с полями id (тип int), amount (тип double) и type (тип String, который может принимать значения "deposit" или "withdrawal").
 *
 * Создай список объектов типа Transaction.
 *
 * Используя функциональные интерфейсы из пакета java.util.function и лямбда-выражения, выполни следующие действия:
 *
 * Печать всех транзакций: Используй Consumer для печати каждой транзакции в списке.
 * Фильтрация по типу транзакции: Используй Predicate для фильтрации списка транзакций по типу "deposit".
 * Подсчет общей суммы по типу транзакции: Используй Function для преобразования списка Transaction в общую сумму по типу транзакции.
 * Поиск транзакции по id: Используй Function для поиска транзакции по id. Если транзакция не найдена, верни null.
 * Создание новой транзакции: Используй Supplier для создания новой транзакции.
 */
public class Task2 {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 2.4, "deposit"));
        transactions.add(new Transaction(2, 2.7, "deposit"));
        transactions.add(new Transaction(3, 3.1, "withdrawal"));
        transactions.add(new Transaction(4, 2.5, "withdrawal"));
        transactions.add(new Transaction(5, 4.2, "deposit"));

        System.out.println("----Печать всех транзакций----");
        transactions.forEach(System.out::println);
        System.out.println();

        System.out.println("----Фильтрация по типу транзакции----");
        Predicate<Transaction> predicateDepositType = transaction -> transaction.type.equals("deposit");
        Predicate<Transaction> predicateWithdrawalType = transaction -> transaction.type.equals("withdrawal");
        //TODO Выделить отдельным методом
        List<Transaction> depositType = transactions.stream()
                .filter(predicateDepositType)
                .collect(Collectors.toList());
        List<Transaction> withdrawalType = transactions.stream()
                .filter(predicateWithdrawalType)
                .collect(Collectors.toList());
        depositType.forEach(System.out::println);
        withdrawalType.forEach(System.out::println);
        System.out.println();

        System.out.println("----Подсчет общей суммы по типу транзакции----");
        Function<List<Transaction>, Double> totalDeposit = transList -> transList.stream()
                .filter(predicateDepositType)
                .mapToDouble(transaction -> transaction.amount)
                .sum();
        double totalDeposits = totalDeposit.apply(transactions);
        System.out.println("Общая сумма депозита: " + totalDeposits);
        System.out.println();

        System.out.println("----Поиск транзакции по id----");
        int idNum = 1;
        List<Transaction> trans = transactions.stream()
                .filter(transaction -> transaction.id == idNum)
                .collect(Collectors.toList());
        if (!trans.isEmpty()) {
            System.out.println(trans);
        }
        System.out.println();

        System.out.println("----Создание новой транзакции----");
        Supplier<Transaction> supplier = () -> new Transaction(6, 5.2, "deposit");
        transactions.add(supplier.get());
        transactions.forEach(System.out::println);
    }
}

class Transaction {
    int id;
    double amount;
    String type;

    public Transaction(int id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
