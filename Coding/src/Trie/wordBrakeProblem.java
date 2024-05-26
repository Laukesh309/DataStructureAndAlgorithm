package Trie;

public class wordBrakeProblem {

    static class Node {
        boolean eow;
        Node[] children = new Node[26];

        Node() {
            this.eow = false;
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void buildTrie(String str) {
        Node currentNode = root;
        for (int i = 0; i < str.length(); i++) {
            int currentIndex = str.charAt(i) - 'a';
            if (currentNode.children[currentIndex] == null) {
                Node newNode = new Node();
                currentNode.children[currentIndex] = newNode;
            }
            currentNode = currentNode.children[currentIndex];
        }
        currentNode.eow = true;
    }

    public static boolean isValid(String key) {
        Node currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            int currentIndex = key.charAt(i) - 'a';
            if (currentNode.children[currentIndex] == null) {
                return false;
            }
            currentNode = currentNode.children[currentIndex];
            if (currentNode.eow) {
                System.out.println("root " + key.charAt(i));
                currentNode = root;
            }
        }
        return currentNode == root;
    }

    public static void main(String[] args) {
        String str[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < str.length; i++) {
            buildTrie(str[i]);
        }
        String key = "ilikemobile";

        System.out.println(isValid(key));

    }

}
