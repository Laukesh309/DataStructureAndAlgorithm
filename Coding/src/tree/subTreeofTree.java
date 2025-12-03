package tree;

public class subTreeofTree {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
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

    public static boolean isSubTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        return isSubTree(root1.prev, root2.prev) && isSubTree(root1.next, root2.next);

    }

    public static boolean findSubTree(Node root1, Node root2) {
        if (root1 == null) {
            return false;
        }
        if (root1.data == root2.data && isSubTree(root1.prev, root2.prev) && isSubTree(root1.next, root2.next)) {
            return true;
        }
        return findSubTree(root1.prev, root2) || findSubTree(root1.next, root2);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int arr2[] = { 2, 4, 6, -1, -1, -1, 5, -1, -1 };
        subTreeofTree st1 = new subTreeofTree();
        Node root1 = st1.buildTree(arr);
        subTreeofTree st2 = new subTreeofTree();
        Node root2 = st2.buildTree(arr2);
        System.out.println(root1.data);
        System.out.println(root2.data);
        System.out.println(findSubTree(root1, root2));

    }

}
