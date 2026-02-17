class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, they are the same
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other is not, they are different
        if (p == null || q == null) {
            return false;
        }

        // If values are different, they are not the same
        if (p.val != q.val) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}