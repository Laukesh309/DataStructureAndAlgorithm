package StriverTrie;

import java.util.ArrayList;
import java.util.HashSet;

public class wordSearchTwo {

    static class Node {
        Node link[] = new Node[26];
        boolean eof;

        Node() {
            this.eof = false;
        }
    }

    Node root;

    wordSearchTwo() {
        root = new Node();

    }

    public void insert(String word) {
        Node tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (tempRoot.link[ch - 'a'] == null) {
                tempRoot.link[ch - 'a'] = new Node();
            }
            tempRoot = tempRoot.link[ch - 'a'];
        }
        tempRoot.eof = true;
    }

    public static void searchString(int row, int column, Node root, char board[][], String result,
            HashSet<String> finalResult) {
        if (root == null) {
            return;
        }
        if (row < 0 || column < 0 || row > board.length - 1 || column > board[0].length - 1
                || board[row][column] == '$') {
            return;
        }
        char ch = board[row][column];
        if (root.link[ch - 'a'] != null) {
            board[row][column] = '$';
            Node nextRoot = root.link[ch - 'a'];
            if (nextRoot.eof == true) {
                String tempResult = result + ch;
                finalResult.add(tempResult);
            }
            searchString(row - 1, column, nextRoot, board, result + ch, finalResult);
            searchString(row + 1, column, nextRoot, board, result + ch, finalResult);
            searchString(row, column + 1, nextRoot, board, result + ch, finalResult);
            searchString(row, column - 1, nextRoot, board, result + ch, finalResult);
            board[row][column] = ch;

        } else {
            return;
        }
    }

    public static void main(String[] args) {
        char board[][] = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        wordSearchTwo ws = new wordSearchTwo();
        ws.insert("oath");
        ws.insert("pea");
        ws.insert("eat");
        ws.insert("rain");
        HashSet<String> finalResult = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                searchString(i, j, ws.root, board, "", finalResult);
            }
        }
        System.out.println(finalResult);

    }

}
