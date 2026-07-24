package recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0, n, result);
        return result;
    }

    private void solve(char[][] board, int row, int n, List<List<String>> result) {
        if (row == n) {
            result.add(construct(board, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, row + 1, n, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {

        // same column
        int r = row;
        while (r >= 0) {
            if (board[r][col] == 'Q')
                return false;
            r--;
        }

        // upper-left diagonal
        r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        // upper-right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }

        return true;
    }

    private List<String> construct(char[][] board, int n) {
        List<String> config = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            config.add(new String(board[i]));
        }
        return config;
    }
}
