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
 class pair{
    TreeNode node;
    boolean isdone;

    pair(TreeNode node,boolean isdone){
        this.node=node;
        this.isdone=isdone;
    }
 }
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        Stack<pair> st=new Stack<>();

        if(root==null){
            return ll;
        }

        st.add(new pair(root,false));
        while(!st.isEmpty()){
            pair rv=st.pop();
            if(rv.isdone){
                ll.add(rv.node.val);
                continue;
            }
            if(rv.node.right!=null){
                st.add(new pair(rv.node.right,false));
            }
            st.add(new pair(rv.node,true));
            if(rv.node.left!=null){
                st.add(new pair(rv.node.left,false));
            }
        }
        return ll;
    }
}