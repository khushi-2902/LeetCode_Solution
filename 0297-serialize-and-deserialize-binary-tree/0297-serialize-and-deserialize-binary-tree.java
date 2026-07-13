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

    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                sb.append("#,");
                continue;
            }

            sb.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {

        if (data.length() == 0)
            return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (!arr[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.left);
            }
            i++;

            if (!arr[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(node.right);
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