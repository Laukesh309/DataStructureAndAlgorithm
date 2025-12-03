package top150InterviewProblem.Tree;

public class subTreeOfAnotherTree {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    int currentIndex = -1;

    public Node buildTree(int nodes[]) {
        currentIndex++;
        if (nodes[currentIndex] == -1) {
            return null;
        }
        Node currentNode = new Node(nodes[currentIndex]);
        currentNode.prev = buildTree(nodes);
        currentNode.next = buildTree(nodes);
        return currentNode;

    }

    public static boolean isSubTree(Node headFirst, Node headSecond) {
        if (headFirst == null) {
            if (headSecond == null) {
                return true;
            } else {
                return false;
            }
        }

        if (headFirst.data == headSecond.data && isSubTree(headFirst.prev, headSecond.prev)
                && isSubTree(headFirst.next, headSecond.next)) {
            return true;
        }
        return isSubTree(headFirst.prev, headSecond) || isSubTree(headFirst.next, headSecond);
    }

    public static void main(String[] args) {
        int nodes1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes2[] = { 2, 4, -1, -1, 5, -1, -1 };
        subTreeOfAnotherTree st = new subTreeOfAnotherTree();
        subTreeOfAnotherTree st2 = new subTreeOfAnotherTree();
        Node firstRoot = st.buildTree(nodes1);
        Node secondRoot = st2.buildTree(nodes2);
        System.out.println(firstRoot.data);
        System.out.println(secondRoot.data);
        System.out.println(isSubTree(firstRoot, secondRoot));
    }

}
