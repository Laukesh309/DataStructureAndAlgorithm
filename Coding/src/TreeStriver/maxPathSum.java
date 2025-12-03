package TreeStriver;

public class maxPathSum {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        int maxPath;
        int maxValue;

        Pair(int maxPath, int maxValue) {
            this.maxPath = maxPath;
            this.maxValue = maxValue;
        }
    }

    static int curIndex = -1;

    public static Node createTree(int arr[]) {
        curIndex++;
        if (arr[curIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[curIndex]);
        newNode.left = createTree(arr);
        newNode.right = createTree(arr);
        return newNode;
    }

    public static Pair findMaxValue(Node root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE);
        }
        Pair left = findMaxValue(root.left);
        Pair right = findMaxValue(root.right);
        int maxPath = Math.max(Math.max(left.maxPath + root.data, right.maxPath + root.data), root.data);
        int currValue = Math.max(Math.max(maxPath, Math.max(left.maxValue, right.maxValue)),
                left.maxPath + right.maxPath + root.data);
        return new Pair(maxPath, currValue);

    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, -1, 1, -1, -1 };
        Node root = createTree(arr);

        System.out.println(findMaxValue(root).maxValue);
    }

}
