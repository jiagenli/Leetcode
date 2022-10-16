package main.com.ljg.leetcode;

public class LC75 {
    /**
     * 一个指针记录0 1 的位置
     * @param nums
     */
    public void sortColors(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, index, i);
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, index, i);
                index++;
            }
        }
    }

    /**
     * 双指针做法
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0;i < nums.length; i++) {
            // 等于0时切换
            if (nums[i] == 0) {
                swap(nums, i, p0);
                // 0后有1的情况，需要把换掉的1再挪到p1的位置
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) { // 等于1时切换
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
