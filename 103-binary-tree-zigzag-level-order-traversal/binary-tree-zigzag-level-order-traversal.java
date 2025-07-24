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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ll=new ArrayList<>();
        if(root==null)return ll;
        Deque<TreeNode> q=new LinkedList<>();
        boolean isleft=true;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            while(size-->0){
                if(isleft){
                TreeNode rv=q.pollFirst();
                temp.add(rv.val);
                if(rv.left!=null)q.add(rv.left);
                if(rv.right!=null)q.add(rv.right);
                }
                else{
                    TreeNode rv=q.pollLast();
                    temp.add(rv.val);
                    if(rv.right!=null)q.addFirst(rv.right);
                    if(rv.left!=null)q.addFirst(rv.left);
                }
            }
            ll.add(new ArrayList<>(temp));
            isleft=!isleft;
        }
        return ll;
    }
}