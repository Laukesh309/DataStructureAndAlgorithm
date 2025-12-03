package TreeStriver;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import java.util.ArrayList;

public class topViewTree {
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
        int level;
        int data;

        Pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    static class NodePair {
        Node node;
        int cd;

        NodePair(Node node, int cd) {
            this.node = node;
            this.cd = cd;
        }
    }

    static int currentIndex = -1;

    public static Node createTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node currentNode = new Node(arr[currentIndex]);
        currentNode.left = createTree(arr);
        currentNode.right = createTree(arr);
        return currentNode;

    }

    public static void findTopView(TreeMap<Integer, Pair> finalResult, int cd, Node root, int level) {
        if (root == null) {
            return;
        }
        if (!finalResult.containsKey(cd) || level < finalResult.get(cd).level) {
            finalResult.put(cd, new Pair(root.data, level));
        }
        findTopView(finalResult, cd - 1, root.left, level + 1);
        findTopView(finalResult, cd + 1, root.right, level + 1);
    }

    public static void bottomView(Node root) {
        Queue<NodePair> que = new LinkedList<>();
        que.add(new NodePair(root, 0));
        TreeMap<Integer, Integer> result = new TreeMap<>();
        while (!que.isEmpty()) {
            NodePair curPair = que.poll();
            int cd = curPair.cd;
            Node curNode = curPair.node;
            result.put(curPair.cd, curNode.data);
            if (curNode.left != null) {
                que.add(new NodePair(curNode.left, cd - 1));
            }
            if (curNode.right != null) {
                que.add(new NodePair(curNode.right, cd + 1));
            }
        }

    }

    public static void leftView(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                Node curNode = que.poll();
                if (i == 0) {
                    result.add(curNode.data);
                }
                if (curNode.left != null) {
                    que.add(curNode.left);
                }
                if (curNode.right != null) {
                    que.add(curNode.right);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, -1, -1 };
        Node root = createTree(arr);
        TreeMap<Integer, Pair> finalResult = new TreeMap<>();
        findTopView(finalResult, 0, root, 0);
        ArrayList<Integer> result = new ArrayList<>();

        for (int item : finalResult.keySet()) {
            result.add(finalResult.get(item).data);
        }
        System.out.println(result);

    }

}
