package Trie;

import java.util.*;

class Node {
    private Node[] letters = new Node[26];
    private String word;
    private boolean isEnd = false;

    public void set(char ch, Node node) {
        letters[ch - 'a'] = node;
    }

    public boolean containsChar(char ch) {
        return letters[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return letters[ch - 'a'];
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setEnd(boolean end) {
        this.isEnd = end;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new LinkedList<>();
        Node root = new Node();
        for (String word : words) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!temp.containsChar(ch)) {
                    temp.set(ch, new Node());
                }
                temp = temp.get(ch);
            }
            temp.setWord(word);
            temp.setEnd(true);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWordsHelper(board, i, j, list, root);
            }
        }
        return list;
    }

    private void findWordsHelper(char[][] board, int i, int j, List<String> list, Node root) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length)
            return;
        char ch = board[i][j];
        if (ch == '.' || !root.containsChar(ch))
            return;
        root = root.get(ch);
        if (root.isEnd()) {
            list.add(root.getWord());
            root.setEnd(false);
        }

        board[i][j] = '.';
        findWordsHelper(board, i, j + 1, list, root);
        findWordsHelper(board, i + 1, j, list, root);
        findWordsHelper(board, i, j - 1, list, root);
        findWordsHelper(board, i - 1, j, list, root);
        board[i][j] = ch;
    }
}