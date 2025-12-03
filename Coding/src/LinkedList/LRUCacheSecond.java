package LinkedList;

import java.util.HashMap;

public class LRUCacheSecond {

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> hashMap;

    public LRUCacheSecond(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    public void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void addNode(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        nextNode.prev = node;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        Node node = hashMap.get(key);
        deleteNode(node);
        addNode(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            Node tempNode = hashMap.get(key);
            tempNode.value = value;
            deleteNode(tempNode);
            addNode(tempNode);
            return;
        }
        Node newNode = new Node(key, value);
        if (hashMap.size() >= capacity) {
            hashMap.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        hashMap.put(key, newNode);
        addNode(newNode);
    }

    public static void main(String[] args) {
        LRUCacheSecond lRUCache = new LRUCacheSecond(1);
        System.out.println(lRUCache.get(6));
        System.out.println(lRUCache.get(8));
        lRUCache.put(12, 1);
        System.out.println("testing2");
        System.out.println(lRUCache.get(2));
        lRUCache.put(15, 11);
        System.out.println("testing2");
        lRUCache.put(5, 2);

        lRUCache.put(1, 15);
        lRUCache.put(4, 2);
        System.out.println(lRUCache.get(4));
        lRUCache.put(15, 15);

    }

}
