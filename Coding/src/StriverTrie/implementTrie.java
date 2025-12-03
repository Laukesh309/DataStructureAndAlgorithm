package StriverTrie;

class Node {
    Node link[] = new Node[26];
    boolean flag;

    Node() {
        for (int i = 0; i < 26; i++) {
            link[i] = null;
        }
        flag = false;

    }

}

public class implementTrie {
    Node root;

    implementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.link[ch - 'a'] == null) {
                temp.link[ch - 'a'] = new Node();
            }
            temp = temp.link[ch - 'a'];
        }
        temp.flag = true;

    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.link[ch - 'a'] == null) {
                return false;
            }
            temp = temp.link[ch - 'a'];
        }
        if (temp.flag == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
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
        implementTrie im = new implementTrie();
        im.insert("apple");
        im.insert("app");
        System.out.println(im.search("apple"));
        System.out.println(im.startsWith("b"));

    }

}
