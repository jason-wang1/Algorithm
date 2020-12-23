package org.alg.algorithm.jason.week4;

import java.util.Arrays;

/**
 * Descreption: 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 *
 * Date: 2020年12月23日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q04FriendCircles {
    public static void main(String args[]){
        int[][] circles = {{1,1,1}, {1,1,1}, {1,1,1}};
        System.out.println(new Q04FriendCircles().findCircleNum(circles));
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];

        // 初始化，每个节点自己是一个集合
        Arrays.fill(parent, -1);

        // 按照关系进行分组
        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j < M.length; j++) {
                if (M[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }

        // 统计集合个数
        int cnt = 0;
        for (int i = 0; i < M.length; i++) {
            if (parent[i] == -1)
                cnt ++;
        }

        return cnt;
    }

    private int find(int[] parent, int i){
        if (parent[i] == -1){
            return i;
        } else {
            int rootSet = find(parent, parent[i]);
            parent[i] = rootSet;
            return rootSet;
        }
    }

    private void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset){
            parent[xset] = yset;
        }
    }


}
