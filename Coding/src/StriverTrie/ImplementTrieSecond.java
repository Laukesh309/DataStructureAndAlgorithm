package StriverTrie;

class Node1 {
    Node1 node[] = new Node1[26];
    int totalCount;
    boolean flag;

    Node1() {
        this.totalCount = 0;
        this.flag = false;
    }
}

public class ImplementTrieSecond {
    Node1 root;

    ImplementTrieSecond() {
        root = new Node1();
    }

    public void insert(String words) {
        Node1 tempRoot = root;
        for (int i = 0; i < words.length(); i++) {
            char ch = words.charAt(i);
            if (tempRoot.node[ch - 'a'] == null) {
                tempRoot.node[ch - 'a'] = new Node1();
            }
            tempRoot = tempRoot.node[ch - 'a'];
            tempRoot.totalCount = tempRoot.totalCount + 1;
        }
        tempRoot.flag = true;
    }

    public int countWordsEqual(String word) {
        Node1 tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (tempRoot.node[ch - 'a'] != null) {
                tempRoot = tempRoot.node[ch - 'a'];
            } else {
                return 0;
            }
        }
        return tempRoot.totalCount;
    }

    public static void main(String[] args) {
        ImplementTrieSecond ts = new ImplementTrieSecond();
        ts.insert("samsung");
        ts.insert("samsung");
        System.out.println(ts.countWordsEqual("samsung"));

    }
}
