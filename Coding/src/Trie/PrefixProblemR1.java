package Trie;

public class PrefixProblemR1 {

    static class Node {
        Node children[] = new Node[26];
        boolean eow;
        int count;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.eow = false;
            this.count = 0;
        }
    }

    public static Node root = new Node();

    public static void buildTree(String str) {
        Node currentNode = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (currentNode.children[idx] == null) {
                Node newNode = new Node();
                currentNode.children[idx] = newNode;
            }
            currentNode.count = currentNode.count + 1;
            currentNode = currentNode.children[idx];
        }
        currentNode.eow = true;
    }

    public static String findAllPrefixValue(String str) {
        Node currentNode = root;
        String strResult = "";
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            currentNode = currentNode.children[idx];
            if (currentNode.count == 1) {
                return strResult + str.charAt(i);
            }
            strResult = strResult + str.charAt(i);
        }
        return strResult;
    }

    public static void main(String[] args) {
        String arr[] = { "zebra", "dog", "duck", "dove" };
        String result[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            buildTree(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = findAllPrefixValue(arr[i]);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
