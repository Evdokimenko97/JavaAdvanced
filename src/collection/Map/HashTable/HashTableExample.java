package collection.Map.HashTable;

import collection.Map.HashMap.Student;

import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Double, Student> hashtable = new Hashtable<>();
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Marya", "Ivanova", 1);
        Student st3 = new Student("Sergey", "Petrov", 4);
        Student st4 = new Student("Igor", "Igorevich", 5);
        Student st5 = new Student("Vasilyi", "Vasilievich", 1);

        // Ìועמהû put
        hashtable.put(5.8, st1);
        hashtable.put(9.3, st2);
        hashtable.put(7.2, st3);
        hashtable.put(8.7, st4);
        hashtable.put(7.9, st5);

        System.out.println(hashtable);
    }
}
