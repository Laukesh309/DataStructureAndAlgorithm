package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class topView {

    static class Node {
        int data;
        int currIndex;
        Node prev;
        Node next;

        Node(int data, int currentIndex) {
            this.data = data;
            this.currIndex = currentIndex;
        }
    }

    int currentIndex = -1;

    public Node buildTree(int arr[], int cIndex) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex], cIndex);
        newNode.prev = buildTree(arr, cIndex - 1);
        newNode.next = buildTree(arr, cIndex + 1);
        return newNode;

    }

    public static void getTopView(Node root) {
        TreeMap<Integer, Integer> hm = new TreeMap<>();

        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()) {
            Node element = que.remove();
            if (element == null) {
                if (que.isEmpty()) {
                    break;
                } else {
                    que.add(null);
                }
            } else {
                if (!hm.containsKey(element.currIndex)) {
                    hm.put(element.currIndex, element.data);
                }

                if (element.prev != null) {
                    que.add(element.prev);
                }
                if (element.next != null) {
                    que.add(element.next);
                }
            }
        }
        for (int item : hm.values()) {
            System.out.print(item + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, -1, 4, -1, 5, -1, 6, -1, -1, 3, -1, -1 };
        topView tv = new topView();
        Node root = tv.buildTree(arr, 0);
        getTopView(root);

    }

}
