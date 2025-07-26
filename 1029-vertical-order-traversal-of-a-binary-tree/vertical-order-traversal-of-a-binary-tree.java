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
        pair(){}
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        if(root!=null){
            q.add(new pair(root,0));
        }
        while(!q.isEmpty()){
            int size=q.size();
            HashMap<Integer,List<Integer>> temp=new HashMap<>();
            while(size-->0){
                pair rv=q.poll();
                if(!temp.containsKey(rv.idx)){
                    temp.put(rv.idx,new ArrayList<>());
                }
                temp.get(rv.idx).add(rv.node.val);
                if(rv.node.left!=null){
                    q.add(new pair(rv.node.left,rv.idx-1));
                }
                if(rv.node.right!=null){
                    q.add(new pair(rv.node.right,rv.idx+1));
                }
            }
            for(int key:temp.keySet()){
                List<Integer> temp2=temp.get(key);
                Collections.sort(temp2);
                if(!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                for(int i:temp2){
                    map.get(key).add(i);
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int key:map.keySet()){
            ans.add(new ArrayList(map.get(key)));
        }
        return ans;
    }
}