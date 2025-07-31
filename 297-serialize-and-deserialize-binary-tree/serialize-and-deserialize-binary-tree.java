/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder str=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        str.append(String.valueOf(root.val));
        q.add(root);
        while(!q.isEmpty()){
            TreeNode rv=q.poll();
            if(rv.left!=null){
                str.append(","+String.valueOf(rv.left.val));
                q.add(rv.left);
            }
            else{
                str.append(",*");
            }
            if(rv.right!=null){
                str.append(","+String.valueOf(rv.right.val));
                q.add(rv.right);
            }
            else{
                str.append(",*");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] arr=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int idx=1;
        while(!q.isEmpty()){
            TreeNode rv=q.poll();
            if(!arr[idx].equals("*")){
                rv.left=new TreeNode(Integer.parseInt(arr[idx]));
                q.add(rv.left);
            }
            idx++;
            if(!arr[idx].equals("*")){
                rv.right=new TreeNode(Integer.parseInt(arr[idx]));
                q.add(rv.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));