package TreeStriver;

public class SearchBST {
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

    public static TreeNode findNode(TreeNode root, int value) {
        if (root == null || root.data == value) {
            return root;
        }
        if (root.data < value) {
            return findNode(root.right, value);
        } else {
            return findNode(root.left, value);
        }
    }

    public static TreeNode findCeil(TreeNode root, int value, int ceil[]) {
        if (root == null || root.data == value) {
            return root;
        }
        if (root.data > value) {
            ceil[0] = root.data;
            return findCeil(root.left, value, ceil);
        } else {
            return findCeil(root.right, value, ceil);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 3, 2, -1, -1, 4, -1, -1, 6, -1, 9, -1, -1, 13, 11, -1, -1, 14, -1, -1 };
        int ceil[] = { -1 };
        TreeNode root = createTree(arr);
        // TreeNode temp = findNode(root, 8, ceil);
        TreeNode temp = findCeil(root, 8, ceil);
        System.out.println(temp);
        System.out.println(ceil[0]);

    }

}
