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
    public int maxPathSum(TreeNode root) {
        int[] ans={Integer.MIN_VALUE};
        find(root,ans);
        return ans[0];
    }

    public int find(TreeNode root,int[] ans){
        if(root==null)return 0;
        int l=find(root.left,ans);
        int r=find(root.right,ans);
        int pass=Math.max(Math.max(l,r)+root.val,root.val);
        int c=Math.max(l+r+root.val,pass);
        ans[0]=Math.max(ans[0],c);
        return pass;
    }
}