package LinkedList;

import java.util.LinkedList;

public class LInkedListCollection {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        System.out.println(ll);
        ll.addFirst(30);
        System.out.println(ll);
        ll.addLast(40);
        System.out.println(ll);
        ll.add(2, 60);
        System.out.println(ll);
        System.out.println(ll.get(2));
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }

}
