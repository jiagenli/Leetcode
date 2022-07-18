package main.com.ljg.leetcode;

public class LC5 {
    /**
     * 这道题的想法就是从字符串的每一位开始遍历，一种奇数的，一种偶数的
     * 奇数的从第i位开始向两边扩散
     * 偶数的从第i，i+1位开始向两边扩散
     * 然后判断这两种回文串的长度
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            String temp = s1.length() > s2.length() ? s1 : s2;
            max = temp.length() > max.length() ? temp : max;
        }
        return max;
    }

    private String palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
