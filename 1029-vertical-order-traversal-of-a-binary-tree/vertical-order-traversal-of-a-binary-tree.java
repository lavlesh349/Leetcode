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
        int level;
        pair(TreeNode node,int idx,int level){
            this.node=node;
            this.idx=idx;
            this.level=level;
        }
        pair(){}
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        if(root!=null){
            q.add(new pair(root,0,0));
        }
        while(!q.isEmpty()){
            pair rv=q.poll();
            if(!map.containsKey(rv.idx)){
                map.put(rv.idx,new TreeMap<>());
            }
            if(!map.get(rv.idx).containsKey(rv.level)){
                map.get(rv.idx).put(rv.level,new PriorityQueue<>());
            }
            map.get(rv.idx).get(rv.level).add(rv.node.val);
            if(rv.node.left!=null){
                q.add(new pair(rv.node.left,rv.idx-1,rv.level+1));
            }
            if(rv.node.right!=null){
                q.add(new pair(rv.node.right,rv.idx+1,rv.level+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int key:map.keySet()){
            List<Integer> ll=new ArrayList<>();
            for(int key2:map.get(key).keySet()){
                while(!map.get(key).get(key2).isEmpty()){
                    ll.add(map.get(key).get(key2).poll());
                }
            }
            ans.add(new ArrayList<>(ll));
        }
        return ans;
    }
}