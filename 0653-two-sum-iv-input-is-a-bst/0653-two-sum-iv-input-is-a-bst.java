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

    class BSTIterator {

        Stack<TreeNode> st = new Stack<>();
        boolean reverse;

        BSTIterator(TreeNode root, boolean reverse) {
            this.reverse = reverse;
            pushAll(root);
        }

        void pushAll(TreeNode node) {
            while (node != null) {
                st.push(node);
                if (reverse)
                    node = node.right;
                else
                    node = node.left;
            }
        }

        int next() {
            TreeNode node = st.pop();

            if (reverse)
                pushAll(node.left);
            else
                pushAll(node.right);

            return node.val;
        }
    }

    public boolean findTarget(TreeNode root, int k) {

        if (root == null)
            return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {

            int sum = i + j;

            if (sum == k)
                return true;
            else if (sum < k)
                i = left.next();
            else
                j = right.next();
        }

        return false;
    }
}