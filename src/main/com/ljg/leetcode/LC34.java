package main.com.ljg.leetcode;

/**
 * 这道题还是二分查找，分别找左边界与右边界
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int l = searchLeft(nums, target);
        int r = searchRight(nums, target);
        return new int[]{l, r};
    }

    /**
     * 查找左边界
     * @param nums
     * @param target
     * @return
     */
    private int searchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            // 与target相等时，保持边界向左边收缩
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        // 没找到的情况
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private int searchRight(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            // 与target相等时，保持边界向右边收缩
            if (nums[middle] <= target) {
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }
        if (right < 0) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }
}
