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
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,new int[]{0},Long.MAX_VALUE);
    }

    public TreeNode construct(int[] preorder,int[] idx,long upper){
        if(idx[0]>=preorder.length || preorder[idx[0]]>=upper){
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx[0]++]);
        root.left=construct(preorder,idx,root.val);
        root.right=construct(preorder,idx,upper);
        return root;
    }
}