package main.com.ljg.leetcode;

public class LC124 {
    int max = Integer.MIN_VALUE;

    /**
     * 还是后序遍历的思路来做
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return this.max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftVal = Math.max(maxGain(root.left), 0);
        int rightVal = Math.max(maxGain(root.right), 0);
        // 节点的最大值，用来比较 this.max
        int curVal = root.val + leftVal + rightVal;
        this.max = Math.max(this.max, curVal);
        // 返回节点的贡献值
        return root.val + Math.max(leftVal, rightVal);
    }
}
