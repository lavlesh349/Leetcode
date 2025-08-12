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
        TreeNode node;
        int idx;

        pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
        TreeNode getKey(){
            return this.node;
        }
        int getValue(){
            return this.idx;
        }
    }
    public int countNodes(TreeNode root) {
        int ans=0;
        int h=0;
        Queue<pair> q=new LinkedList<>();
        if(root!=null){
            q.add(new pair(root,1));
        }
        while(!q.isEmpty()){
            int size=q.size();
            int prev=(int)(Math.pow(2,h)-1);
            while(size-->0){
                pair p=q.poll();
                if(size==0){
                    ans=p.getValue();
                }
                if(p.getKey().left!=null)q.add(new pair(p.getKey().left,p.getValue()*2));
                if(p.getKey().right!=null)q.add(new pair(p.getKey().right,1+p.getValue()*2));
            }
        }
        return ans;
    }
}