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
        int idx;
        TreeNode node;

        pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }

       public String toString(){
            return node.val+" "+idx+" ";
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<pair> q=new LinkedList<>();
        if(root!=null)q.add(new pair(root,1));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().idx;
            int max=0;
            // System.out.println(q);
            while(size-->0){
                pair rv=q.poll();
                if(size==0)max=rv.idx;
                if(rv.node.left!=null)q.add(new pair(rv.node.left,2*rv.idx));
                if(rv.node.right!=null)q.add(new pair(rv.node.right,2*rv.idx+1));
            }
            ans=Math.max(ans,max-min+1);
        }
        return ans;
    }
}