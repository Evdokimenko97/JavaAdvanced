package collection.List.Iterators;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        String s = "madam";
        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reverseIterator = list.listIterator(list.size());
        boolean isPolindrome = true;
        while (iterator.hasNext() && reverseIterator.hasPrevious()) {
            if(!iterator.next().equals(reverseIterator.previous())) {
                isPolindrome = false;
                break;
            }
        }

        System.out.println(isPolindrome);
    }
}
