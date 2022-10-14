package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {
    /**
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> res = new ArrayList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 当right比下一个区间的开头大时
            if (right >= intervals[i][0] && right <= intervals[i][1]) {
                right = intervals[i][1];
            } else if (right < intervals[i][0]) { // 当right 小于下一个区间的开头时，输出
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        res.add(new int[]{left, right});
        return res.toArray(new int[0][]);
    }
}
