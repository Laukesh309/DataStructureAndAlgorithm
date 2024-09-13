package Sheet.String.Easy;

public class longestCommonPrefix {

    static class Node {

        Node[] children;
        int count;

        Node() {

            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
            this.count = 0;

        }
    }

    static Node root = new Node();

    public static void createTrie(String str[]) {

        String resutl = "";
        for (int i = 0; i < str.length; i++) {
            Node currentNode = root;
            String str1 = str[i];
            for (int j = 0; j < str1.length(); j++) {
                int currentIndex = str1.charAt(j) - 'a';
                if (currentNode.children[currentIndex] == null) {
                    currentNode.children[currentIndex] = new Node();
                    currentNode.count = currentNode.count + 1;
                }
                currentNode = currentNode.children[currentIndex];
                if
            }

        }
    }

    public static void main(String[] args) {
        String str[] = { "flower", "flow", "flight" };
        createTrie(str);

    }

}
