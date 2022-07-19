package main.com.ljg.leetcode;

/**
 * 这道题的想法是双指针，高度较小的一边优先向内移动，然后比较极值
 */
public class LC11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = height[l] < height[r] ? Math.max(max, (r - l) * height[l++]) : Math.max(max, (r - l) * height[r--]);
        }
        return max;
    }
}
