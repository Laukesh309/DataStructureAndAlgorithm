package Trie;

public class createTrie {

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

    public static boolean searchPrefix(String str) {
        Node currentNode = rootNode;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.eow;

    }

    public static void main(String[] args) {
        String[] str = { "the", "a", "there", "their", "any", "thee" };

        for (int i = 0; i < str.length; i++) {
            buildTrie(str[i]);
        }
        System.out.println(searchPrefix("their"));
    }

}
