package org.alg.algorithm.jason.week3;

/**
 * Descreption: XXXX<br/>
 * Date: 2020年12月19日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q06MaxValue {
    public static void main(String args[]){
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(new Q06MaxValue().maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }

}
