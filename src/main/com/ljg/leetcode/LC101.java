package main.com.ljg.leetcode;

public class LC101 {
    /**
     * 左右子树对称，要
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && dfs(t1.left, t2.right) && dfs(t1.right, t2.left);
    }
}
