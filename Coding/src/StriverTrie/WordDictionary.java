package StriverTrie;

public class WordDictionary {

    static class Node {
        Node link[] = new Node[26];
        boolean flag;

        Node() {
            this.flag = false;
        }
    }

    Node root;

    public WordDictionary() {
        this.root = new Node();

    }

    public void addWord(String word) {
        Node tempNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (tempNode.link[ch - 'a'] == null) {
                tempNode.link[ch - 'a'] = new Node();
            }
            tempNode = tempNode.link[ch - 'a'];
        }
        tempNode.flag = true;

    }

    public static boolean checkString(String str, Node root, int index) {
        if (index >= str.length() && root.flag) {
            return true;
        }
        if (index >= str.length() && root.flag == false) {
            return false;
        }
        char ch = str.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.link[i] != null && checkString(str, root.link[i], index + 1)) {
                    return true;
                }
            }
            return false;
        }
        if (root.link[ch - 'a'] == null) {
            return false;
        }

        return checkString(str, root.link[ch - 'a'], index + 1);

    }

    public boolean search(String word) {
        return checkString(word, root, 0);
    }

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("b..")); // return False);
    }

}
