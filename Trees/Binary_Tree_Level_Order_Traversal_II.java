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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while(len-->0){
                TreeNode currNode = queue.poll();
                levelList.add(currNode.val);
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            list.add(0, levelList);
        }
        return list;
    }
}