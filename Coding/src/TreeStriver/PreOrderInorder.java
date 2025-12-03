package TreeStriver;

import java.util.HashMap;

public class PreOrderInorder {
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

    static int curIndex = 0;

    public static TreeNode findTree(HashMap<Integer, Integer> hs, int preOrder[], int inOrder[], int start, int end) {

        if (end < start) {
            return null;
        }

        int curData = preOrder[curIndex];
        curIndex++;
        TreeNode newNode = new TreeNode(curData);
        int index = hs.get(curData);
        newNode.left = findTree(hs, preOrder, inOrder, start, index - 1);
        newNode.right = findTree(hs, preOrder, inOrder, index + 1, end);
        return newNode;
    }

    public static void main(String[] args) {
        int preOrder[] = { -1 };
        int inOrder[] = { -1 };
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            hs.put(inOrder[i], i);
        }

        findTree(hs, preOrder, inOrder, 0, inOrder.length - 1);
    }

}
