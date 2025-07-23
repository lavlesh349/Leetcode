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
    public int diameterOfBinaryTree(TreeNode root) {
        return find(root);
    }

    public int find(TreeNode root){
        if(root==null)return 0;
        int l=find(root.left);
        int r=find(root.right);
        int c=height(root.left)+height(root.right)+2;
        return Math.max(l,Math.max(c,r));
    }

    public int height(TreeNode root){
        if(root==null)return -1;
        return Math.max(height(root.left),height(root.right))+1;
    }
}