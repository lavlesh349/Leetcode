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
    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode l=helper(root.left);
        TreeNode r=helper(root.right);
        root.left=null;
        root.right=l;
        l=root;
        while(l.right!=null){
            l=l.right;
        }
        l.right=r;
        return root;
    }
}