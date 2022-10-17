package main.com.ljg.leetcode;

public class LC79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    int[] xOffset = {-1, 0, 1, 0};
    int[] yOffset = {0, 1, 0, -1};
    private boolean dfs(char[][] board, int x, int y, int index, String word) {
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[x][y];
        // 不是改了全局的，而是作为形参传了下去
        board[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int newX = x + xOffset[i];
            int newY = y + yOffset[i];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || board[newX][newY] == '.') {
                continue;
            }
            if (dfs(board, x + xOffset[i], y + yOffset[i], index + 1, word)) {
                return true;
            }
        }
        board[x][y] = temp;
        return false;
    }
}
