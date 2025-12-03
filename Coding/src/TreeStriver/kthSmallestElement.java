package TreeStriver;

import java.util.ArrayList;

public class kthSmallestElement {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
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

    public static TreeNode findKthElement(TreeNode root, int count[], int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = findKthElement(root.left, count, k);
        if (left != null) {
            return left;
        }
        count[0]++;
        if (count[0] == k) {
            return root;
        } else {
            return findKthElement(root.right, count, k);
        }
    }

    public static int findMinDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftDifference = Integer.MAX_VALUE;
        int rightDifference = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDifference = Math.abs(root.val - root.left.val);
        }
        if (root.right != null) {
            rightDifference = Math.abs(root.val - root.right.val);
        }
        return Math.min(Math.min(leftDifference, rightDifference),
                Math.min(findMinDifference(root.left), findMinDifference(root.right)));

    }

    public static void findInorder(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        findInorder(result, root.left);
        result.add(root.val);
        findInorder(result, root.right);

    }

    public static void main(String[] args) {
        int arr[] = { 543, 384, -1, 445, -1, -1, 652, -1, 699, -1, -1 };
        TreeNode root = createTree(arr);
        // int count[] = { 0 };
        // int first = findKthElement(root, count, 1).val;
        // System.out.println(first);
        // count[0] = 0;
        // int second = findKthElement(root, count, 2).val;
        // System.out.println(second);
        // System.out.println(findMinDifference(root));
        ArrayList<Integer> result = new ArrayList<>();
        findInorder(result, root);
        System.out.println(result);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.size() - 1; i++) {
            int diff = Math.abs(result.get(i) - result.get(i + 1));
            min = Math.min(min, diff);
        }
        System.out.println(min);

    }

}
