package com.perye.array;

/**
 * 36.有效的数独
 * 链接：https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author honggd
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (row[i][num] || col[j][num] || box[boxIndex][num]) {
                        return false;
                    }

                    row[i][num] = true;
                    col[j][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}
