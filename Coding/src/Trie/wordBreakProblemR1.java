package Trie;

public class wordBreakProblemR1 {

    static class Node {
        Node children[] = new Node[26];
        boolean eow;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.eow = false;
        }
    }

    public static Node rootNode = new Node();

    public static void buildTrie(String str) {
        Node currentNode = rootNode;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                Node newNode = new Node();
                currentNode.children[index] = newNode;
            }
            currentNode = currentNode.children[index];
        }
        currentNode.eow = true;
    }

    public static boolean findTargetElement(String str) {
        Node currentNode = rootNode;
        for (int i = 0; i < str.length();) {
            int index = str.charAt(i) - 'a';
            if (currentNode.children[index] == null && currentNode.eow == false) {
                return false;
            }
            if (currentNode.children[index] == null && currentNode.eow == true) {
                currentNode = rootNode;
            } else {
                currentNode = currentNode.children[index];
                i++;
            }
        }
        return currentNode.eow;
    }

    public static void main(String[] args) {
        String str[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        String targetString = "mobilei";

        for (int i = 0; i < str.length; i++) {
            buildTrie(str[i]);
        }
        System.out.println(findTargetElement(targetString));
    }

}
