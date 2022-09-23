package main.com.ljg.leetcode;

public class LC48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // first turn it up and down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // then turn the side of the lower right corner
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
