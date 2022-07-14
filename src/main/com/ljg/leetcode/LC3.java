package main.com.ljg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int temp = 1; // 内部最大长度
        for (int i = 0; i < s.length(); i++) {
            int toLastDis = i - map.getOrDefault(s.charAt(i), -1);
            // 这个的思路是比较上一次字母出现的距离和当前最长字符串长度的距离
            //如果上一次字母出现的距离太远，说明当前子字符串已经有重复字符
            temp = toLastDis > temp ? (temp + 1) : toLastDis;
            max = Math.max(temp, max);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    /**
     * 滑动窗口法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int right = -1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while ((right + 1) < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            max = Math.max(max, (right - i + 1));
        }
        return max;
    }
}
