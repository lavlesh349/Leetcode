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
        return construct(preorder,inorder,0,n);
    }
    int p=0;
    public TreeNode construct(int[] pre,int[] in,int is,int ie){
        if(is>ie){
            return null;
        }
        TreeNode root=new TreeNode(pre[p]);
        int idx=is;
        while(idx<=ie){
            if(in[idx]==pre[p]){
                break;
            }
            idx++;
        }
        p++;
        root.left=construct(pre,in,is,idx-1);
        root.right=construct(pre,in,idx+1,ie);
        return root;
    }
}