package lambda.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * �������� �������: ������ ������ � �������������� �������������� �����������
 * �������:
 * ������ ����� Transaction � ������ id (��� int), amount (��� double) � type (��� String, ������� ����� ��������� �������� "deposit" ��� "withdrawal").
 *
 * ������ ������ �������� ���� Transaction.
 *
 * ��������� �������������� ���������� �� ������ java.util.function � ������-���������, ������� ��������� ��������:
 *
 * ������ ���� ����������: ��������� Consumer ��� ������ ������ ���������� � ������.
 * ���������� �� ���� ����������: ��������� Predicate ��� ���������� ������ ���������� �� ���� "deposit".
 * ������� ����� ����� �� ���� ����������: ��������� Function ��� �������������� ������ Transaction � ����� ����� �� ���� ����������.
 * ����� ���������� �� id: ��������� Function ��� ������ ���������� �� id. ���� ���������� �� �������, ����� null.
 * �������� ����� ����������: ��������� Supplier ��� �������� ����� ����������.
 */
public class Task2 {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 2.4, "deposit"));
        transactions.add(new Transaction(2, 2.7, "deposit"));
        transactions.add(new Transaction(3, 3.1, "withdrawal"));
        transactions.add(new Transaction(4, 2.5, "withdrawal"));
        transactions.add(new Transaction(5, 4.2, "deposit"));

        System.out.println("----������ ���� ����������----");
        transactions.forEach(System.out::println);
        System.out.println();

        System.out.println("----���������� �� ���� ����������----");
        Predicate<Transaction> predicateDepositType = transaction -> transaction.type.equals("deposit");
        Predicate<Transaction> predicateWithdrawalType = transaction -> transaction.type.equals("withdrawal");
        //TODO �������� ��������� �������
        List<Transaction> depositType = transactions.stream()
                .filter(predicateDepositType)
                .collect(Collectors.toList());
        List<Transaction> withdrawalType = transactions.stream()
                .filter(predicateWithdrawalType)
                .collect(Collectors.toList());
        depositType.forEach(System.out::println);
        withdrawalType.forEach(System.out::println);
        System.out.println();

        System.out.println("----������� ����� ����� �� ���� ����������----");
        Function<List<Transaction>, Double> totalDeposit = transList -> transList.stream()
                .filter(predicateDepositType)
                .mapToDouble(transaction -> transaction.amount)
                .sum();
        double totalDeposits = totalDeposit.apply(transactions);
        System.out.println("����� ����� ��������: " + totalDeposits);
        System.out.println();

        System.out.println("----����� ���������� �� id----");
        int idNum = 1;
        List<Transaction> trans = transactions.stream()
                .filter(transaction -> transaction.id == idNum)
                .collect(Collectors.toList());
        if (!trans.isEmpty()) {
            System.out.println(trans);
        }
        System.out.println();

        System.out.println("----�������� ����� ����������----");
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
