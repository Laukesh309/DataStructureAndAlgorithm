package Trie;

import java.util.ArrayList;

public class prefixProblem {

    static class Node {
        Node[] children = new Node[26];
        int count;
        boolean eow;

        Node() {
            this.count = 0;
            this.eow = false;
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void buildTrieTree(String str) {
        Node currentNode = root;
        for (int i = 0; i < str.length(); i++) {
            int currentIndex = str.charAt(i) - 'a';
            if (currentNode.children[currentIndex] == null) {
                Node newNode = new Node();
                currentNode.children[currentIndex] = newNode;
            }
            currentNode = currentNode.children[currentIndex];
            currentNode.count = currentNode.count + 1;
        }
        currentNode.eow = true;

    }

    public static String prefixString(String str) {
        Node currentNode = root;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int currentIndex = str.charAt(i) - 'a';
            currentNode = currentNode.children[currentIndex];
            if (currentNode.count == 1) {
                return result + str.charAt(i);
            }
            result = result + str.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = { "zebra", "dog", "duck", "dove" };
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            buildTrieTree(str[i]);
        }
        for (int i = 0; i < str.length; i++) {
            result.add(prefixString(str[i]));
        }
        System.out.println(result);

    }

}
