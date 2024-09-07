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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(currNode == null){
                str.append("n ");
                continue;
            }
            str.append(currNode.val + " ");
            queue.add(currNode.left);
            queue.add(currNode.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] arr = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        queue.add(root);
        for(int i=1; i<arr.length; i++){
            TreeNode currNode = queue.poll();
            if(!arr[i].equals("n")){
                currNode.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(currNode.left);
            }
            if(!arr[++i].equals("n")){
                currNode.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(currNode.right);
            }
        }
        return root;
    }
}
