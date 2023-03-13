package Chapter_6;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeExample {

    public static void main (String [] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        LinkedList<Integer> ll = new LinkedList<>();

        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(1);
        ad.addLast(5);
        System.out.println(ad); // 1,4,3,2,1,5
        ad.removeLast();
        ad.removeLastOccurrence(1);
        System.out.println(ad); // 1,4,3,2
        System.out.println(" --------------------- ");

        // Ctrl + R to bring up search and replace window
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(1);
        ll.addLast(5);
        System.out.println(ll); // 1,4,3,2,1,5
        ll.removeLast();
        ll.removeLastOccurrence(1);
        System.out.println(ll); // 1,4,3,2


    }
}
