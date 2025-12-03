package tree;

public class DiameterTree {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class Info {
        int dia;
        int height;

        Info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    int currentIndex = -1;

    public Node buildPreOrderTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex]);
        newNode.prev = buildPreOrderTree(arr);
        newNode.next = buildPreOrderTree(arr);
        return newNode;
    }

    public static int findHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.prev), findHeight(root.next));
    }

    public static int findDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDia = findDiameter(root.prev);
        int rightDia = findDiameter(root.next);
        int currentDia = 1 + findHeight(root.next) + findHeight(root.prev);
        return Math.max(currentDia, Math.max(rightDia, leftDia));
    }

    public static Info findDiameterSecond(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = findDiameterSecond(root.prev);
        Info rightInfo = findDiameterSecond(root.next);
        int currentHeight = 1 + Math.max(leftInfo.height, rightInfo.height);
        int currentDia = Math.max(Math.max(1 + leftInfo.height + rightInfo.height, leftInfo.dia),
                rightInfo.dia);
        return new Info(currentDia, currentHeight);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 9, -1, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        DiameterTree dt = new DiameterTree();
        Node root = dt.buildPreOrderTree(arr);
        System.out.println(findDiameter(root));
        System.out.println(findDiameterSecond(root).dia);
    }

}
