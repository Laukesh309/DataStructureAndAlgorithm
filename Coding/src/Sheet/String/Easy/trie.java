package Sheet.String.Easy;

public class trie {

    static class Node {
        Node[] children = new Node[26];
        boolean eof;

        Node() {
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
            this.eof = false;
        }
    }

    public static Node rootNode = new Node();

    public static void insertNodeString(String[] str) {
        for (int i = 0; i < str.length; i++) {
            Node currentNode = rootNode;
            String str1 = str[i];
            for (int j = 0; j < str1.length(); j++) {
                int index = str1.charAt(j) - 'a';
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new Node();
                }
                currentNode = currentNode.children[index];
            }
            currentNode.eof = true;
        }
    }

    public static boolean searchKey(String key) {
        Node currentNode = rootNode;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.eof;
    }

    public static void main(String[] args) {
        String[] str = { "the", "a", "there", "their", "any", "thee" };
        insertNodeString(str);
        System.out.println(searchKey("an"));
    }

}
