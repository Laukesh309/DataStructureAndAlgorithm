package TreeStriver;

import java.util.ArrayList;

public class lowestCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int currentIndex = -1;

    public static TreeNode createTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        TreeNode currentNode = new TreeNode(arr[currentIndex]);
        currentNode.left = createTree(arr);
        currentNode.right = createTree(arr);
        return currentNode;

    }

    public static TreeNode findAncestor(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = findAncestor(root.left, first, second);
        TreeNode righNode = findAncestor(root.right, first, second);
        if (root == first && leftNode == second || root == first && righNode == second) {
            return root;
        }
        if (root == second && leftNode == first || root == second && righNode == first) {
            return root;
        }
        if (root == first || root == second) {
            return root;
        }
        if (leftNode == null) {
            return righNode;
        }
        if (righNode == null) {
            return leftNode;
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1 };
        ArrayList<TreeNode> result = new ArrayList<>();
        TreeNode root = createTree(arr);
        findAncestor(root, result, 5, 1);
        System.out.println(result);
        result.ge)
    }
}
