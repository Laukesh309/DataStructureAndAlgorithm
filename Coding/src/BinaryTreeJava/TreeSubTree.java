package BinaryTreeJava;

public class TreeSubTree {

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
        // public static int currentIndex = -1;
        int currentIndex = -1;

        public Node buildTree(int arr[]) {
            currentIndex++;
            System.out.println("currentIndex " + currentIndex);
            if (arr[currentIndex] == -1) {
                return null;
            }
            Node newNode = new Node(arr[currentIndex]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;
        }

        public static void preOrderTraversal(Node head) {
            if (head == null) {
                return;
            }
            System.out.print(head.data + " ");
            preOrderTraversal(head.left);
            preOrderTraversal(head.right);
        }

        public static boolean isIdentical(Node head1, Node head2) {
            if (head1 == null && head2 == null) {
                return true;
            }
            if (head1 == null || head2 == null || head1.data != head2.data) {
                return false;
            }
            if (!isIdentical(head1.left, head2.left)) {
                return false;
            }
            if (!isIdentical(head1.right, head2.right)) {
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node head1, Node head2) {
            if (head1 == null) {
                return false;
            }
            if (head1.data == head2.data) {
                if (isIdentical(head1, head2)) {
                    return true;
                }
            }

            return isSubtree(head1.left, head2) || isSubtree(head1.right, head2);

        }
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int node2[] = { 2, 4, -1, -1, 5, -1, -1 };

        BinaryTree bt = new BinaryTree();
        Node binaryTreeHead1 = bt.buildTree(node);
        BinaryTree bt2 = new BinaryTree();
        Node binaryTreeHead2 = bt2.buildTree(node2);
        bt.preOrderTraversal(binaryTreeHead1);
        System.out.println();
        bt2.preOrderTraversal(binaryTreeHead2);
        System.out.println();
        System.out.println(BinaryTree.isSubtree(binaryTreeHead1, binaryTreeHead2));
        // System.out.println();
        // bt.preOrderTraversal(binaryTreeHead2);
    }

}
