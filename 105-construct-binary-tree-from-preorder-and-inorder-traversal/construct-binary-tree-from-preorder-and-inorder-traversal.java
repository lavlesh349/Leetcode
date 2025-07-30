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
        return construct(preorder,inorder,0,n,0,n);
    }

    public TreeNode construct(int[] pre,int[] in,int ps,int pe,int is,int ie){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode root=new TreeNode(pre[ps]);
        int idx=is;
        while(idx<=ie){
            if(in[idx]==pre[ps]){
                break;
            }
            idx++;
        }
        root.left=construct(pre,in,ps+1,ps+idx-is,is,idx-1);
        root.right=construct(pre,in,ps-is+idx+1,pe,idx+1,ie);
        return root;
    }
}