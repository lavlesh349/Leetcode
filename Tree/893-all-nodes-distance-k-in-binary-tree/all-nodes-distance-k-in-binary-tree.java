/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> hs=new HashMap<>();
        fillparent(root,hs);
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> ll=new ArrayList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        if(target!=null)q.add(target);
        int dis=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                if(dis==k){
                    ll.add(q.poll().val);
                    continue;
                }
                TreeNode rv=q.poll();
                if(rv.left!=null && !visited.contains(rv.left)){
                    q.add(rv.left);    
                }
                if(rv.right!=null && !visited.contains(rv.right)){
                    q.add(rv.right);
                }
                if(hs.containsKey(rv) && !visited.contains(hs.get(rv))){
                    q.add(hs.get(rv));
                }
                visited.add(rv);
            }
            dis++;
        }
        return ll;
    }

    public void fillparent(TreeNode root,HashMap<TreeNode,TreeNode> hs){
        if(root==null)return;
        if(root.right!=null){
            hs.put(root.right,root);
            fillparent(root.right,hs);
        }
        if(root.left!=null){
            hs.put(root.left,root);
            fillparent(root.left,hs);
        }
    }
}