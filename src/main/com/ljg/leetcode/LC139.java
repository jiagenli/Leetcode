package main.com.ljg.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    /**
     * 这道题用动态规划来做，应该有更优化的剪枝策略
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        System.out.println(set);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 看j处的状态，和j后的单词是否在词典中
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
