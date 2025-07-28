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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        TreeNode tar=fill(root,start,map);
        // for(TreeNode i:map.keySet()){
        //     System.out.println(i.val+" "+map.get(i).val);
        // }
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> vis=new HashSet<>();
        if(root!=null)q.add(tar);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            // for(TreeNode i:q)System.out.print(i.val+" ");
            // System.out.println();
            while(size-->0){
                TreeNode rv=q.poll();
                vis.add(rv);
                if(rv.left!=null && !vis.contains(rv.left))q.add(rv.left);
                if(rv.right!=null && !vis.contains(rv.right))q.add(rv.right);
                if(map.containsKey(rv) && !vis.contains(map.get(rv)))q.add(map.get(rv));
            }
            ans++;
        }
        return ans-1;
    }

    public TreeNode fill(TreeNode root,int start,HashMap<TreeNode,TreeNode> map){
        if(root==null){
            return null;
        }
        TreeNode l=null;
         TreeNode r=null;
        if(root.left!=null){
            map.put(root.left,root);
        l=fill(root.left,start,map);
        }
        if(root.right!=null){
map.put(root.right,root);
        
       r=fill(root.right,start,map);
        }
        if(root.val==start)return root;
        if(l!=null)return l;
        return r;
    }
}