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
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        boolean isbst=true;
    }
    public boolean isValidBST(TreeNode root) {
        return check(root).isbst;
    }

    public pair check(TreeNode root){
        if(root==null)return new pair();
        pair l=check(root.left);
        pair r=check(root.right);
        pair p=new pair();
        p.max=Math.max(root.val,Math.max(l.max,r.max));
        p.min=Math.min(root.val,Math.min(l.min,r.min));
        p.isbst=l.isbst && r.isbst && root.val>l.max && root.val<r.min;
        return p;
    }
}