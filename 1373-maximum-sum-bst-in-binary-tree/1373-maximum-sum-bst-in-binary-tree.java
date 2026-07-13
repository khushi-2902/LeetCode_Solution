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

    class Node {
        boolean isBST;
        int min;
        int max;
        int sum;

        Node(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Node dfs(TreeNode root) {

        if (root == null)
            return new Node(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Node left = dfs(root.left);
        Node right = dfs(root.right);

        if (left.isBST && right.isBST &&
                root.val > left.max &&
                root.val < right.min) {

            int sum = left.sum + right.sum + root.val;
            ans = Math.max(ans, sum);

            return new Node(
                    true,
                    Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    sum
            );
        }

        return new Node(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}