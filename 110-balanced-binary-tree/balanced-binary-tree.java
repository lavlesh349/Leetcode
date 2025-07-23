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
        return find(root).is;
    }

    public pair find(TreeNode root){
        if(root==null)return new pair(0,true);
        pair l=find(root.left);
        pair r=find(root.right);
        pair p=new pair();
        p.h=Math.max(l.h,r.h)+1;
        p.is=l.is && r.is && Math.abs(l.h-r.h)<=1;
        return p;
    }
}