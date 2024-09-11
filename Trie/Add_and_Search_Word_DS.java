package Trie;

class Node {
    private Node[] letters = new Node[26];
    private boolean flag = false;

    public Node[] getLetters() {
        return letters;
    }

    public void set(char ch, Node node) {
        letters[ch - 'a'] = node;
    }

    public boolean containsChar(char ch) {
        return letters[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return letters[ch - 'a'];
    }

    public boolean isEnd() {
        return flag;
    }

    public void setEnd() {
        flag = true;
    }
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.containsChar(ch)) {
                temp.set(ch, new Node());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int i, Node currNode) {
        if (i == word.length())
            return currNode.isEnd();

        char ch = word.charAt(i);
        if (ch == '.') {
            Node[] childrens = currNode.getLetters();
            for (Node children : childrens) {
                if (children != null && searchHelper(word, i + 1, children)) {
                    return true;
                }
            }
            return false;
        }
        if (!currNode.containsChar(ch))
            return false;
        return searchHelper(word, i + 1, currNode.get(ch));
    }
}
