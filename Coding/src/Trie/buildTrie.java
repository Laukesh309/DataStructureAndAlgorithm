package Trie;

public class buildTrie {

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

    public static void buildTrieImp(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int currentIndex = str.charAt(i) - 'a';
            if (curr.children[currentIndex] == null) {
                Node newNode = new Node();
                curr.children[currentIndex] = newNode;
            }
            curr = curr.children[currentIndex];
        }
        curr.eow = true;
    }

    public static boolean searchString(String str) {
        Node currentNode = root;
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
            buildTrieImp(str[i]);
        }
        System.out.println(searchString("thor"));
    }

}
