package TreeStriver;

import java.util.ArrayList;

public class morisTraversalInorder {
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

    public static void MorisTraversal(TreeNode root) {
        TreeNode cur = root;
        ArrayList<Integer> result = new ArrayList<>();
        while (cur != null) {
            System.out.println("secondTesting");
            if (cur.left == null) {
                result.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    // System.out.println("testing");
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }
                if (prev.right == cur) {
                    result.add(cur.data);
                    prev.right = null;
                    cur = cur.right;
                }

            }
        }
        System.out.println(result);
    }

    public static void flattendTree(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode prev = cur.left;
            if (prev == null) {
                cur = cur.right;
            } else {
                while (prev.right != null) {
                    System.out.println(prev.data);
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, 6, -1, -1, 3, -1, -1 };
        TreeNode root = createTree(arr);
        // MorisTraversal(root);
        flattendTree(root);
    }

}
