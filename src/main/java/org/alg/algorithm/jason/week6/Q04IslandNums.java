package org.alg.algorithm.jason.week6;

public class Q04IslandNums {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };

        int islandsNum = new Q04IslandNums().numIslands(grid);
        System.out.println(islandsNum);
    }

    private boolean[][] isPassed;
    private int res;

    public int numIslands(char[][] grid) {
        isPassed = new boolean[grid.length][grid[0].length];
        res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isPassed[i][j] || grid[i][j] == '0')
                    continue;

                res++;
                dfs(grid, i, j);
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        isPassed[i][j] = true;
        if (grid[i][j] == '1'){
            if (i < grid.length-1 && !isPassed[i+1][j]){
                dfs(grid, i+1, j); // 往下走
            }

            if (i > 0 && !isPassed[i-1][j]){
                dfs(grid, i-1, j); // 往上走
            }

            if (j < grid[0].length-1 && !isPassed[i][j+1]){
                dfs(grid, i, j+1); // 往右走
            }

            if (j > 0 && !isPassed[i][j-1]){
                dfs(grid, i, j-1); // 往左走
            }
        }
    }
}
