package main.com.ljg.leetcode;

public class LC114 {
    /**
     * 二叉树的先序遍历，保存右子树节点，然后挪动
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            TreeNode temp = root.right;
            TreeNode t = root.left;
            if (root.left != null) {
                while (t != null && t.right != null) {
                    t = t.right;
                }
                t.right = temp;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
