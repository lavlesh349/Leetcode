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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length-1;
        return construct(postorder,inorder,0,n,0,n);
    }

    public TreeNode construct(int[] post,int[] in,int ps,int pe,int is,int ie){
        if(ps>pe || is>ie){
            return null;
        }
        TreeNode root=new TreeNode(post[pe]);
        int idx=is;
        while(idx<=ie){
            if(in[idx]==post[pe]){
                break;
            }
            idx++;
        }
        root.left=construct(post,in,ps,ps+idx-is-1,is,idx-1);
        root.right=construct(post,in,ps+idx-is,pe-1,idx+1,ie);
        return root;
    }
}