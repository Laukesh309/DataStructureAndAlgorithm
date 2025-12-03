package TreeStriver;

import java.util.ArrayList;

public class SerializeDeserialize {

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

    public static Node createTree(ArrayList<Integer> arr, int curIndex[]) {
        curIndex[0]++;
        if (arr.get(curIndex[0]) == -1) {
            return null;
        }
        Node newNode = new Node(arr.get(curIndex[0]));
        newNode.left = createTree(arr, curIndex);
        newNode.right = createTree(arr, curIndex);
        return newNode;
    }

    public static void main(String[] args) {
        int curIndex[] = { -1 };
        ArrayList<Integer> arr = new ArrayList<>();

    }

}
