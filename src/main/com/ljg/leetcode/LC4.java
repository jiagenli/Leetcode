package main.com.ljg.leetcode;

public class LC4 {
    /**
     * 这个的时间复杂度还是O(m+n)，思想就是从两个数组开头逐一比较，选出中间数字
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int middle = (len1 + len2) / 2;
        int b = 0, a = b; // b 是后一个数字，也是奇数时的输出数字；a是前一个数字，每次循环时有上一轮的b赋值
        int i = 0, j = 0, count = 0;
        while (i < len1 || j < len2) {
            int n1 = i < len1 ? nums1[i] : Integer.MAX_VALUE;
            int n2 = j < len2 ? nums2[j] : Integer.MAX_VALUE;
            if (count == (middle + 1)) break;
            a = b;
            if (n1 <= n2) {
                b = n1;
                i++;
            } else {
                b = n2;
                j++;
            }
            count++;
        }
        if ((len1 + len2) % 2 == 0) {
            return ((double) (a + b)) / 2;
        } else {
            return (double) b;
        }
    }
}
