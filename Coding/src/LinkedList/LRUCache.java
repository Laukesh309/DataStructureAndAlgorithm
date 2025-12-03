package LinkedList;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int value;
        Node nextPointer;

        Node(int value) {
            this.value = value;
            this.nextPointer = null;
        }

    }

    Node head;
    Node tail;
    HashMap<Integer, Integer> hs;
    int capacity;

    public LRUCache(int capacity) {
        this.hs = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;

    }

    public int get(int key) {
        return 0;

    }

    public void put(int key, int value) {
        Node newNode = new Node(key);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextPointer = newNode;
        }
        if (hs.containsKey(key)) {

        }

    }

    public static void main(String[] args) {

    }

}
