package collection.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Zaur");
        queue.offer("Oleg");
        queue.offer("Ivan");
        queue.offer("Masha");
        queue.offer("Aleksandr");
        System.out.println(queue);

        // remove (NoSuchElementException)
        System.out.println(queue.remove());

        // poll, также как и remove, только вместо NoSuchElementException = null
        System.out.println();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // element (NoSuchElementException)
        System.out.println();
        System.out.println(queue.element());

        // peek, также как и element, только вместо NoSuchElementException = null
        System.out.println();
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
