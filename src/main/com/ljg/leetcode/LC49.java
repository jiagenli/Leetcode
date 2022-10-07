package main.com.ljg.leetcode;

import java.util.*;

public class LC49 {
    /**
     * 暴力解法，对数组中的每个字符串排序，再将字符串加入到相同map的value中
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] cstr = s.toCharArray();
            Arrays.sort(cstr);
            String sorted = String.valueOf(cstr);
            List<String> l;
            if (map.containsKey(sorted)) {
                l = map.get(sorted);
                l.add(s);
            } else {
                l = new ArrayList<>();
                l.add(s);
            }
            map.put(sorted, l);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
