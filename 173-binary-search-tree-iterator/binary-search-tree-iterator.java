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

    public BSTIterator(TreeNode root) {
        construct(root);
    }
    TreeNode head=null;
    TreeNode prev=null;
    public void construct(TreeNode root){
        if(root==null)return;
        construct(root.left);
        if(head==null){
            head=root;
        }
        else{
            prev.right=root;
        }
        prev=root;
        root.left=null;
        construct(root.right);
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