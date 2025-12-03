package TreeStriver;

public class validateBST {
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

    public static boolean validateBST(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return validateBST(root.left, min, (long) root.data) && validateBST(root.right, (long) root.data, max);

    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, -1, -1, 3, -1, -1 };
        TreeNode root = createTree(arr);
        System.out.println(validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE));

    }

}