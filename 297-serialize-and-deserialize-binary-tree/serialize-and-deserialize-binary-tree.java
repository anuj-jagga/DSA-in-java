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
        if(root == null) return "null";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            
            if(curr == null) res.append("null ");
            else {
                res.append(curr.val + " ");
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;
        String[] values = data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int i = 1;

        while(!q.isEmpty() ){
            TreeNode parent = q.poll();
            if(! values[i].equals("null")){
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.left);
            }

            i++;
            if( ! values[i].equals("null")){
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));