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
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            while(size-->0){
                TreeNode rv=q.poll();
                temp.add(rv.val);
                if(rv.left!=null)q.add(rv.left);
                if(rv.right!=null)q.add(rv.right);
            }
            if(ll.size()%2!=0){
                Collections.reverse(temp);
            }
            ll.add(new ArrayList<>(temp));
        }
        return ll;
    }
}