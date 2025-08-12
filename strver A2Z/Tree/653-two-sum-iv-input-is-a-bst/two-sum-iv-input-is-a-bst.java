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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null)q.add(root);
        while(!q.isEmpty()){
            TreeNode rv=q.poll();
            if(set.contains(rv.val))return true;
            set.add(k-rv.val);
            if(rv.left!=null)q.add(rv.left);
            if(rv.right!=null)q.add(rv.right);
        }
        return false;
    }
}