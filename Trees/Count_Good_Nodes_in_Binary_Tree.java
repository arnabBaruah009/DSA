package Trees;

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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return solve(root, root.val);
    }

    private int solve(TreeNode root, int max){
        if(root==null) return 0;
        int left = solve(root.left, Math.max(max, root.val));
        int right = solve(root.right, Math.max(max, root.val));
        if(root.val >= max) return left+right+1;
        return left+right;
    }
}
