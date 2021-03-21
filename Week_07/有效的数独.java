package com.ken;

import java.util.HashMap;
import java.util.Map;

public class 有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        //将矩阵中的行、列、块信息分别存储
        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] column = new HashMap[9];
        Map<Integer, Integer>[] block = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            column[i] = new HashMap<>();
            block[i] = new HashMap<>();
        }

        //遍历矩阵，将对应的数字进行存储
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j];
                    int blockIndex = (i / 3) * 3 + j / 3;
                    row[i].put(num, row[i].getOrDefault(num, 0) + 1);
                    column[j].put(num, column[j].getOrDefault(num, 0) + 1);
                    block[blockIndex].put(num, block[blockIndex].getOrDefault(num, 0) + 1);

                    //校验现存的记录是否符合数独规则
                    if (row[i].get(num) > 1 || column[j].get(num) > 1 || block[blockIndex].get(num) > 1) return false;
                }
            }
        }
        return true;
    }
}
