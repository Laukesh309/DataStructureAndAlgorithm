package TreeStriver;

public class totalNodeCompleteBinaryTree {

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

    public static int findHeightLeft(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findHeightLeft(root.left);
    }

    public static int findHeightRight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findHeightRight(root.right);
    }

    public static int findTotalNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeigh = findHeightLeft(root.left);
        int rightHeigh = findHeightRight(root.right);
        if (leftHeigh == rightHeigh) {
            return (int) (Math.pow(2, leftHeigh + 1) - 1);
        }
        return 1 + findTotalNode(root.left) + findTotalNode(root.right);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1 };
        TreeNode root = createTree(arr);
        System.out.println(findTotalNode(root));

    }

}
