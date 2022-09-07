package main.com.ljg.leetcode;

/**
 * 这道题的思路是二分查找，由于队列是4 5 6 7 1 2 3 这种队形，我们做这个题时就考虑一点
 * 在有序的地方进行搜索
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            //中间值比左边值大，说明左边队列有序，在其中搜索
            if (nums[0] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) { // 当左值 < 目标值 < 中间值时，说明目标在这个范围内
                    right = middle - 1;
                } else {
                    left = middle + 1;  // 跳出这个范围
                }
            } else {
                if (target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
