package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 这道题的还是深度优先遍历和回溯法来做
 */
public class LC39 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.result = new ArrayList<>();
        dfs(target, 0, 0, candidates, new LinkedList());
        return result;
    }

    private void dfs(int target, int sum, int now, int[] candidates, LinkedList<Integer> seq) {
        if (sum == target) {
            result.add(new ArrayList<>(seq));
            return;
        }
        for (int i = now; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            seq.addLast(candidates[i]);
            dfs(target, sum + candidates[i], i, candidates, seq);
            seq.removeLast();
        }
    }

}
