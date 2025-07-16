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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll=new ArrayList<>();
        dfs(root,0,ll);
        return ll;
    }

    public static void dfs(TreeNode root,int l,List<List<Integer>> ll){
        if(root==null){
            return;
        }
        while(ll.size()<=l){
            ll.add(new ArrayList<>());
        }
        ll.get(l).add(root.val);
        dfs(root.left,l+1,ll);
        dfs(root.right,l+1,ll);
    }
}