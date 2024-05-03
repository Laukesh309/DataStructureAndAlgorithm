package BinaryTreeJava;

public class transformSubTree {
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

    static class BinaryTree {
        static int currentIndex = -1;

        public static Node buildTree(int arr[]) {
            currentIndex++;
            if (arr[currentIndex] == -1) {
                return null;
            }
            Node newNode = new Node(arr[currentIndex]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }

        public static int sumSubTree(Node head) {
            if (head == null) {
                return 0;
            }
            int currentData = head.data;
            head.data = sumSubTree(head.left) + sumSubTree(head.right);
            return currentData + head.data;
        }

        public static void printPreOrderTraversal(Node head) {
            if (head == null) {
                return;
            }
            System.out.print(head.data + " ");
            printPreOrderTraversal(head.left);
            printPreOrderTraversal(head.right);
            return;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(arr);
        // bt.buildTree(arr);
        bt.sumSubTree(root);
        bt.printPreOrderTraversal(root);

    }

}
