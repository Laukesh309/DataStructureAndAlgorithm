package TreeStriver;

import java.util.HashMap;

public class postOrderToInOrder {

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

    public static TreeNode findTreeNode(HashMap<Integer, Integer> hm, int inorder[], int postorder[], int curIndex[],
            int start, int end) {
        if (start > end) {
            return null;
        }
        int item = postorder[curIndex[0]];
        TreeNode newNode = new TreeNode(item);
        curIndex[0]--;
        int index = hm.get(item);
        newNode.right = findTreeNode(hm, inorder, postorder, curIndex, index + 1, end);
        newNode.left = findTreeNode(hm, inorder, postorder, curIndex, start, index - 1);
        return newNode;

    }

    public static void main(String[] args) {
        int inorder[] = { 40, 20, 50, 10, 60, 30 };
        int postorder[] = { 40, 50, 20, 60, 30, 10 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        int size = inorder.length - 1;
        int curIndex[] = { size };
        TreeNode root = findTreeNode(hm, inorder, postorder, curIndex, 0, inorder.length - 1);
        System.out.println(root.val);

    }

}
