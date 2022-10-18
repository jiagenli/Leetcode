package main.com.ljg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin < 0 || preEnd >= preorder.length || inBegin < 0 || inEnd >= inorder.length || preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);
        int inindex = map.get(rootVal);
        int leftCount = inindex - inBegin;
        int rightCount = inEnd - inindex;
        root.left = build(preorder, inorder, preBegin + 1, preBegin + leftCount, inBegin, inindex - 1);
        root.right = build(preorder, inorder, preBegin + leftCount + 1, preBegin + leftCount + rightCount, inindex + 1, inindex + rightCount);
        return root;
    }
}
