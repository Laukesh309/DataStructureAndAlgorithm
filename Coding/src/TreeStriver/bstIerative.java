package TreeStriver;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
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
}

public class bstIerative {
    Stack<TreeNode> st = new Stack<>();

    public bstIerative(TreeNode root) {
        st.add(root);
        root = root.left;
        while (root != null) {
            st.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode tempNode = this.st.pop();
        int result = tempNode.val;
        tempNode = tempNode.right;
        while (tempNode != null) {
            this.st.push(tempNode);
            tempNode = tempNode.left;
        }
        return result;

    }

    public boolean hasNext() {
        if (this.st.isEmpty()) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int arr[] = { 7, 3, -1, -1, 15, 9, -1, -1, 20, -1, -1 };
        TreeNode root = createTree(arr);
    }

}
