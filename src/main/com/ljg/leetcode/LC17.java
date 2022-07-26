package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这题是一道简单的深度优先遍历
 * 注意StringBuilder的使用比较方便
 */
public class LC17 {
    char[][] keyboards= new char[10][];
    {
        keyboards[0] = new char[0];
        keyboards[1] = new char[0];
        keyboards[2] = "abc".toCharArray();
        keyboards[3] = "def".toCharArray();
        keyboards[4] = "ghi".toCharArray();
        keyboards[5] = "jkl".toCharArray();
        keyboards[6] = "mno".toCharArray();
        keyboards[7] = "pqrs".toCharArray();
        keyboards[8] = "tuv".toCharArray();
        keyboards[9] = "wxyz".toCharArray();
    }

    List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int cur = digits.charAt(index) - '0';
        for (int i = 0; i < keyboards[cur].length; i++) {
            sb.append(keyboards[cur][i]);
            dfs(digits, index + 1, sb);
            sb.deleteCharAt(index);
        }
    }
}
