package BinaryTreeJava;

public class kthLevelNode {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    static class BinaryTree {
        static int currentIndex = -1;

        public static Node buildTree(int arr[]) {
            currentIndex++;
            if (arr[currentIndex] == -1 && currentIndex < arr.length) {
                return null;
            }

            Node newNode = new Node(arr[currentIndex]);
            newNode.leftNode = buildTree(arr);
            newNode.rightNode = buildTree(arr);
            return newNode;
        }

        public static void preOrderTraversal(Node head) {
            if (head == null) {
                return;
            }
            preOrderTraversal(head.leftNode);
            System.out.print(head.data + " ");
            preOrderTraversal(head.rightNode);

        }

        public static void printKthLevelTree(Node head, int currentLevel, int keyLevel) {
            if (head == null) {
                return;
            }
            if (currentLevel == keyLevel) {
                System.out.print(head.data + " ");
                return;
            }
            printKthLevelTree(head.leftNode, currentLevel + 1, keyLevel);
            printKthLevelTree(head.rightNode, currentLevel + 1, keyLevel);
            return;
        }

        public static Node lowestCommontAnces(Node head, int n, int m) {
            if (head == null) {
                return null;
            }
            if (head.data == n || head.data == m) {
                return head;

            }
            Node leftSubTree = lowestCommontAnces(head.leftNode, n, m);
            Node rightSubTree = lowestCommontAnces(head.rightNode, n, m);
            if (leftSubTree == null && rightSubTree == null) {
                return null;
            }
            if (leftSubTree == null) {
                return rightSubTree;
            }
            if (rightSubTree == null) {
                return leftSubTree;
            }
            return head;
        }

        public static int findMiniMumDistance(Node head, int n, int m) {
            if (head == null) {
                return 0;
            }
            if (head.data == n || head.data == m) {
                return 1;
            }
            int leftMinValue = findMiniMumDistance(head.leftNode, n, m);
            int rightMinValue = findMiniMumDistance(head.rightNode, n, m);
            if (leftMinValue == 0 && rightMinValue == 0) {
                return 0;
            }
            if (leftMinValue == 0) {
                return rightMinValue;
            }
            if (rightMinValue == 0) {
                return leftMinValue;
            }
            return leftMinValue + rightMinValue;
        }

        public static int kthAncestor(Node head, int data, int k) {
            if (head == null) {
                return -1;
            }
            if (head.data == data) {
                return 1;
            }
            int left = kthAncestor(head.leftNode, data, k);
            int right = kthAncestor(head.rightNode, data, k);

            if (left != -1) {
                if (left + 1 == k) {
                    System.out.println(head.data);
                }
                return left + 1;
            }
            if (right != -1) {
                if (right + 1 == k) {
                    System.out.println(head.data);
                }
                return right + 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(arr);
        // bt.preOrderTraversal(root)2
        bt.printKthLevelTree(root, 1, 4);
        // System.out.println(bt.findMiniMumDistance(root, 4, 6));
        System.out.println(bt.kthAncestor(root, 6, 4));
    }

}
