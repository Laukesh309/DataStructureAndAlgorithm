package BinarySearchTreeRevision;

public class buildBst {

    static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node build(Node root, int value) {
        if (root == null) {
            Node newRoot = new Node(value);
            return newRoot;
        }
        if (value < root.data) {
            root.prev = build(root.prev, value);
        }
        if (value > root.data) {
            root.next = build(root.next, value);
        }
        return root;

    }

    public Node buildBst(int value[]) {
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = build(root, value[i]);
        }
        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.prev);
        System.out.println(root.data);
        inOrderTraversal(root.next);

    }

    public static void main(String[] args) {
        int value[] = { 5, 1, 3, 4, 2, 7 };
        buildBst bt = new buildBst();
        Node root = bt.buildBst(value);
        // System.out.println(root.data);
        inOrderTraversal(root);
    }

}
