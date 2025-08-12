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
        int[] ans={0};
        find(root,ans);
        return ans[0];
    }

    public int find(TreeNode root,int[] ans){
        if(root==null)return -1;
        int l=find(root.left,ans);
        int r=find(root.right,ans);
        int c=l+r+2;
        ans[0]=Math.max(ans[0],c);
        return Math.max(l,r)+1;
    }
}