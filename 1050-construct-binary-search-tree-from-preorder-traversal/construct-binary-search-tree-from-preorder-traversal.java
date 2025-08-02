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
        return construct(preorder,0,preorder.length-1);
    }

    public TreeNode construct(int[] pre,int si,int ei){
        if(si>ei){
            return null;
        }
        TreeNode root=new TreeNode(pre[si]);
        int idx=si+1;
        while(idx<=ei && pre[idx]<pre[si]){
            idx++;
        }
        root.left=construct(pre,si+1,idx-1);
        root.right=construct(pre,idx,ei);
        return root;
    }
}