package TreeStriver;

import java.util.LinkedList;
import java.util.Queue;

import java.util.List;
import java.util.ArrayList;;

public class averageLevel {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int curIndex = -1;

    public static TreeNode createTree(int arr[]) {
        curIndex++;
        if (arr[curIndex] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(arr[curIndex]);
        newNode.left = createTree(arr);
        newNode.right = createTree(arr);
        return newNode;
    }

    public static void printAvg(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = que.poll();
                sum += tempNode.data;
                if (tempNode.left != null) {
                    que.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    que.add(tempNode.right);
                }
            }
            double avgValue = (double) sum / size;
            result.add(avgValue);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        TreeNode root = createTree(arr);
        printAvg(root);

    }

}
