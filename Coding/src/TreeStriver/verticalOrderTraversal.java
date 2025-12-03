package TreeStriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class verticalOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        int index;
        Node data;

        Pair(Node data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    static int curIndex = -1;

    public static Node createTree(int arr[]) {
        curIndex++;
        if (arr[curIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[curIndex]);
        newNode.left = createTree(arr);
        newNode.right = createTree(arr);
        return newNode;
    }

    public static void verticalTraversal(Node root) {
        Queue<Pair> que = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        que.add(new Pair(root, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            int curIndex = curPair.index;
            if (min > curIndex) {
                min = curIndex;
            }
            if (max < curIndex) {
                max = curIndex;
            }
            if (hs.containsKey(curIndex)) {
                hs.get(curIndex).add(curPair.data.data);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curPair.data.data);
                hs.put(curIndex, temp);
            }
            if (curPair.data.left != null) {
                que.add(new Pair(curPair.data.left, curIndex - 1));
            }
            if (curPair.data.right != null) {
                que.add(new Pair(curPair.data.right, curIndex + 1));
            }
        }
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            finalResult.add(hs.get(i));
        }
        System.out.println(finalResult);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, 5, -1, 6, -1, -1, 10, -1, -1, 3, 9, -1, -1, 10, -1, -1 };
        Node root = createTree(arr);
        verticalTraversal(root);

    }
}
