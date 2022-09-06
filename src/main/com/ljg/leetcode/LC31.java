package main.com.ljg.leetcode;

/**
 * 这题的思路是分为四步
 * 1. 从后向前找第一个有序对（i，j）
 * 2. 从j到末尾找到一个尽可能小但比i大的数k
 * 3. 交换i和k
 * 4. 排序j到end(用双指针反转)
 */
public class LC31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        // 寻找代码中的第一个有序对
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 找到第一个比nums[i]大的数nums[j]，因为i之后的数组是倒序的，所以第一个比nums[i]大的数就是：尽可能小但比nums[i]大的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 对i后面的数组排序，变成正序，可以不用sort，因为是逆序，所以双指针反转
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
