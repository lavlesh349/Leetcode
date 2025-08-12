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
class BSTIterator {

    TreeNode head=null;

    public BSTIterator(TreeNode root) {
        construct(root);
    }

    public void construct(TreeNode root){
        if(root==null)return;
        construct(root.right);
        root.right=head;
        head=root;
        construct(root.left);
        root.left=null;
    }
   public int next() {
        int temp=head.val;
        head=head.right;
        return temp;
    }
    
    public boolean hasNext() {
        return head!=null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */