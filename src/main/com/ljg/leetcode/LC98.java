package main.com.ljg.leetcode;

public class LC98 {
    /**
     * 这道题两种做法，
     * 第一种方法由于是二叉搜索树的中序遍历，则可以遍历出来，看是否有序
     * 第二种是先序遍历，注意的是不能直接比较root的值，可以设置形参记录遍历更新的极大值和极小值
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long lower, long higher) {
        if (root == null) {
            return true;
        }

        if (root.val <= lower || root.val >= higher) {
            return false;
        }

        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, higher);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
