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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> PQ = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;
        PQ.add(root);
        while(!PQ.isEmpty()){
            List<Integer> childList = new LinkedList<>();
            int len = PQ.size();
            while(len-->0){
                TreeNode currNode = PQ.poll();
                if(currNode.left != null) PQ.add(currNode.left);
                if(currNode.right != null) PQ.add(currNode.right);
                childList.add(currNode.val);
            }
            list.add(childList);
        }
        return list;
    }
}
