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
    class pair{
        boolean is;
        int h;
        pair(int h,boolean is){
            this.h=h;
            this.is=is;
        }
        pair(){}
    }
    public boolean isBalanced(TreeNode root) {
        return find(root)!=-1;
    }

    public int find(TreeNode root){
        if(root==null)return 0;
        int l=find(root.left);
        int r=find(root.right);
        if(Math.abs(l-r)>1 || l==-1 || r==-1)return -1;
        return Math.max(l,r)+1;
    }
}