package com.ken;

import java.util.ArrayList;
import java.util.List;

public class 解数独 {

    //记录数独矩阵每个位置是否填入数值
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][] block = new boolean[9][9];
    //记录每个尚未填入数值的位置，遍历每个位置进行回溯
    List<int[]> space = new ArrayList<int[]>();
    //开关，用于在得到解以后直接结束每一层递归的后续尝试
    boolean shutDownFlag = false;

    public void solveSudoku(char[][] board) {
        //预扫描数独矩阵，初始化数组和space集合
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = column[j][num] = block[(i / 3) * 3 + j / 3][num] = true;
                } else {
                    space.add(new int[]{i, j});
                }
            }
        }
        //递归回溯
        dfs(board, 0);
    }

    private void dfs(char[][] board, int index) {
        if (index == space.size()) {
            shutDownFlag = true;
            return;
        }
        int[] position = space.get(index);
        int i = position[0], j = position[1], b = (i / 3) * 3 + j / 3;
        for (int k = 0; k < 9 && !shutDownFlag; k++) {
            if (!row[i][k] && !column[j][k] && !block[b][k]) {
                row[i][k] = column[j][k] = block[b][k] = true;
                board[i][j] = (char) (k + '0' + 1);
                dfs(board, index + 1);
                row[i][k] = column[j][k] = block[b][k] = false;
            }
        }
    }
}
