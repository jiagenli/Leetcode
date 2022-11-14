package main.com.ljg.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC207 {
    /**
     * 广度优先遍历法，有向无环图的遍历，拓扑排序
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 入度
        int[] indegrees = new int[numCourses];
        // 每个源点的目标点集合
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 统计每个点的入度，以及每个源点的目标点，加入集合
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
            adjacency.get(p[1]).add(p[0]);
        }
        // 将入度为0的点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 队列出队，让目标点的入度-1，如果目标点为0，则入队
        while (!queue.isEmpty()) {
            int out = queue.poll();
            numCourses--;
            for (int target : adjacency.get(out)) {
                if (--indegrees[target] == 0) {
                    queue.offer(target);
                }
            }
        }

        return numCourses == 0;
    }

    /**
     * 深度优先遍历
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjcency = new ArrayList<>();
        for (int i = 0;i < numCourses; i++) {
            adjcency.add(new ArrayList());
        }
        for (int[] pre : prerequisites) {
            adjcency.get(pre[1]).add(pre[0]);
        }
        // 0未被访问 -1在其他源点的dfs中被访问 1已被自己源点出发的dfs访问
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, flags, adjcency)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, int[] flags, List<List<Integer>> adjcency) {
        // 在本轮dfs中被访问过，说明有环
        if (flags[cur] == 1) {
            return false;
        }
        if (flags[cur] == -1) {
            return true;
        }
        flags[cur] = 1;
        for (int adj : adjcency.get(cur)) {
            if (!dfs(adj, flags, adjcency)) {
                return false;
            }
        }
        flags[cur] = -1;
        return true;
    }
}
