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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> map){
        if(preorderStart > preorderEnd || inorderStart > inorderEnd) return null;

        TreeNode root = new TreeNode(preorder[preorderStart]);
        int indexInInorder = map.get(root.val);
        int leftTreeLength = indexInInorder - inorderStart;

        root.left = buildTreeHelper(preorder, preorderStart+1, preorderStart+leftTreeLength, inorder, inorderStart, indexInInorder-1, map);
        root.right = buildTreeHelper(preorder, preorderStart+leftTreeLength+1, preorderEnd, inorder, indexInInorder+1, inorderEnd, map);
        return root;
    }
}
