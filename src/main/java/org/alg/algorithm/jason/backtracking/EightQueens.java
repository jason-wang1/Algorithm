package org.alg.algorithm.jason.backtracking;

import java.util.*;

/**
 * Descreption: 回溯
 * 八皇后
 * https://leetcode-cn.com/problems/eight-queens-lcci/
 *
 * Date: 2020年12月03日
 *
 * @author WangBo
 * @version 1.0
 */
public class EightQueens {
    public static void main(String args[]){
        List<List<String>> res = new EightQueens().solveNQueens(4);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("=============");
        }
    }

    private List<List<String>> res = new ArrayList<>();
    private int[] queues;
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;


    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[n+n];
        diag2 = new boolean[n+n];
        queues = new int[n];
        dfs(n, 0);
        return res;
    }

    private void dfs(int n, int rowNum) {
        if (rowNum == n) {
            generateBoard(queues, n);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag1[rowNum-j+n] && !diag2[rowNum+j]){
                queues[rowNum] = j;
                col[j] = true;
                diag1[rowNum-j+n] = true;
                diag2[rowNum+j] = true;
                dfs(n, rowNum+1);

                // 回溯
                col[j] = false;
                diag1[rowNum-j+n] = false;
                diag2[rowNum+j] = false;
            }
        }
    }

    private void generateBoard(int[] queues, int n) {
        List<String> track = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            track.add(new String(row));
        }

        res.add(track);
    }
}
