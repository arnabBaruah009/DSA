package Trie;

class Node {
    Node[] letters = new Node[26];
    boolean flag = false;
    Node() {}

    public void set(char ch, Node node){
        letters[ch-'a'] = node;
    }

    public boolean containsChar(char ch){
        return letters[ch-'a'] != null;
    }

    public Node get(char ch){
        return letters[ch-'a'];
    }

    public boolean isEnd(){
        return flag;
    }

    public void setEnd(){
        flag = true;
    }
}

class Trie {
    private Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.containsChar(ch)){
                temp.set(ch, new Node());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.containsChar(ch)){
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!temp.containsChar(ch)){
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }
}
