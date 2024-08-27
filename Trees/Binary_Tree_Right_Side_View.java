package Trees;
import java.util.*;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            boolean added = false;
            while(len-->0){
                TreeNode currNode = queue.poll();
                if(!added){
                    list.add(currNode.val);
                    added = true;
                }
                if(currNode.right != null) queue.add(currNode.right);
                if(currNode.left != null) queue.add(currNode.left);
            }
        }
        return list;
    }
}