package org.alg.algorithm.jason.backtracking;

import java.util.List;

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
        List<List<String>> res = solveNQueens(4);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("=============");
        }
    }

    // TODO
    public static List<List<String>> solveNQueens(int n) {
        return null;
    }
}
