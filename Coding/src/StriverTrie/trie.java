package StriverTrie;

class Node22 {
    Node22 link[] = new Node22[26];
    boolean flag;

    Node22() {
        this.flag = false;
        for (int i = 0; i < 26; i++) {
            this.link[i] = null;
        }
    }

}

public class trie {

    Node22 root;

    trie() {
        this.root = new Node22();
    }

    public void insert(String word) {
        Node22 temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.link[ch - 'a'] == null) {
                temp.link[ch - 'a'] = new Node22();
            }
            temp = temp.link[ch - 'a'];
        }
        temp.flag = true;
    }

    public boolean search(String word) {
        Node22 temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.link[ch - 'a'] == null) {
                System.out.println(ch);
                return false;
            }
            temp = temp.link[ch - 'a'];
        }
        return temp.flag;

    }

    public boolean startsWith(String prefix) {
        Node22 temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (temp.link[ch - 'a'] == null) {
                return false;
            }
            temp = temp.link[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        trie ts = new trie();
        ts.insert("apple");
        System.out.println(ts.search("apple"));

    }

}
