/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        //  helper(root);
        return level(root);
        //  return root;
        
    }public TreeNode helper(TreeNode root){
        if(root==null){
            return root ;
        }
        TreeNode left=helper(root.left);
        TreeNode right=helper(root.right);

        root.left=right;
        root.right=left;
        return root;
         

    }
    public TreeNode level(TreeNode root){
        if(root==null)return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
                    TreeNode node = queue.remove();

             TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);

        }
        return root;
    }
}