package Trees;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        storeToList(head, root, list);
        for(TreeNode currNode : list){
            if(checkNode(head, currNode)) return true;
        }
        return false;
    }

    private void storeToList(ListNode head, TreeNode root, List<TreeNode> list){
        if(root==null) return;
        if(head.val == root.val){
            list.add(root);
        }
        storeToList(head, root.left, list);
        storeToList(head, root.right, list);
    }

    private boolean checkNode(ListNode head, TreeNode root){
        if(head==null) return true;
        if(root==null) return false;

        if(head.val != root.val) return false;
        return checkNode(head.next, root.left) || checkNode(head.next, root.right);
    }
}
