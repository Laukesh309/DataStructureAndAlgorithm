package top150InterviewProblem.Tree;

public class diameterOFTree {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        int dia;
        int ht;

        Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    static int currentIndex = -1;

    public static Node buildTree(int nodes[]) {
        currentIndex++;
        if (nodes[currentIndex] == -1) {
            return null;
        }
        int currentdata = nodes[currentIndex];
        Node temp = new Node(currentdata);
        temp.prev = buildTree(nodes);
        temp.next = buildTree(nodes);
        return temp;

    }

    public static void printTree(Node head) {
        if (head == null) {
            System.out.print(" -1 ");
            return;
        }
        System.out.print(" " + head.data + " ");
        printTree(head.prev);
        printTree(head.next);

    }

    public static Info finddiameter(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info leftInfo = finddiameter(head.prev);
        Info rightInfo = finddiameter(head.next);
        int curDia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
        int curHt = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(curDia, curHt);

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(nodes);
        System.out.println(root.data);
        System.out.println("=====>");
        printTree(root);
        Info cur = finddiameter(root);
        System.out.println("diameter==>");
        System.out.println(cur.dia);
        System.out.println(cur.ht);
    }

}
