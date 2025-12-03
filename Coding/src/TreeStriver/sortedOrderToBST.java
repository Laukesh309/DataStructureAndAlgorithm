package TreeStriver;

public class sortedOrderToBST {

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

    public static TreeNode createBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode newNode = new TreeNode(arr[mid]);
        newNode.left = createBST(arr, start, mid - 1);
        newNode.right = createBST(arr, mid + 1, end);
        return newNode;
    }

    public static void main(String[] args) {
        int arr[] = { -10, -3, 0, 5, 9 };
        TreeNode root = createBST(arr, 0, arr.length - 1);
        System.out.println(root.data);

    }

}
