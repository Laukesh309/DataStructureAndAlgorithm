package tree;

public class kthAncestorNode {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        Node ans;
        int level;

        Info(Node ans, int level) {
            this.ans = ans;
            this.level = level;
        }
    }

    int currentIndex = -1;

    public Node buildTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex]);
        newNode.prev = buildTree(arr);
        newNode.next = buildTree(arr);
        return newNode;
    }

    public Info findKthNode(Node head, int n1, int k) {
        if (head == null) {
            return new Info(null, -1);
        }
        if (head.data == n1) {
            return new Info(head, 0);
        }
        Info leftSubTree = findKthNode(head.prev, n1, k);
        Info rightSubTree = findKthNode(head.next, n1, k);
        if (leftSubTree.ans != null) {
            if (leftSubTree.level == k) {
                return leftSubTree;
            } else {
                return new Info(head, leftSubTree.level + 1);
            }
        }
        if (rightSubTree.ans != null) {
            if (rightSubTree.level == k) {
                return rightSubTree;
            } else {
                return new Info(head, rightSubTree.level + 1);
            }
        }
        return new Info(null, -1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        kthAncestorNode kt = new kthAncestorNode();
        Node root = kt.buildTree(arr);
        int n1 = 5;
        int k = 1;
        Info result = kt.findKthNode(root, n1, k);
        System.out.println(result.ans.data);

    }

}
