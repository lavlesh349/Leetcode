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
        if(root==null){
            return "";
        }
        List<String> ll=new ArrayList<>();
        convert(root,ll);
        StringBuilder str=new StringBuilder();
        for(String s:ll){
            str.append(" "+s);
        }
        return str.toString().substring(1);
    }

    public void convert(TreeNode root,List<String> ll){
        if(root==null){
            return;
        }
        ll.add(String.valueOf(root.val));
        ll.add(root.left==null?"False":"True");
        convert(root.left,ll);
        ll.add(root.right==null?"False":"True");
        convert(root.right,ll);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] arr=data.split(" ");
        return construct(arr,new int[]{0});
    }

    public TreeNode construct(String[] arr,int[] idx){
        if(idx[0]>=arr.length)return null;
        TreeNode root=new TreeNode(Integer.parseInt(arr[idx[0]]));
        idx[0]++;
        if(arr[idx[0]++].equals("True")){
            root.left=construct(arr,idx);
        }
        if(arr[idx[0]++].equals("True")){
            root.right=construct(arr,idx);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));