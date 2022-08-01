package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种遍历字符拼接字符串的题通常就是用深度优先遍历来做
 * 这道题的一个优化是open + close来判断
 * 而我的通常第一想法是长度比较的方式
 *
 */
public class LC22 {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void dfs(StringBuilder sb, int open, int close, int n) {
        if (open + close == n * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            dfs(sb, open + 1, close, n);
            sb.deleteCharAt(close + open);
        }

        if (close < open) {
            sb.append(')');
            dfs(sb, open, close + 1, n);
            sb.deleteCharAt(close + open);
        }
    }

}
