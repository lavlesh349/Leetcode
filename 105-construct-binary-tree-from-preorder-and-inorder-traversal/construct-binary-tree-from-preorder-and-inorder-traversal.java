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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length-1;
        return construct(preorder,inorder,new int[]{0},0,n);
    }
    public TreeNode construct(int[] pre,int[] in,int[] p,int is,int ie){
        if(is>ie){
            return null;
        }
        TreeNode root=new TreeNode(pre[p[0]]);
        int idx=is;
        while(idx<=ie){
            if(in[idx]==pre[p[0]]){
                break;
            }
            idx++;
        }
        p[0]++;
        root.left=construct(pre,in,p,is,idx-1);
        root.right=construct(pre,in,p,idx+1,ie);
        return root;
    }
}