package org.alg.algorithm.jason.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Descreption: 回溯
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * Date: 2020年12月07日
 *
 * @author WangBo
 * @version 1.0
 */
public class Permutations {
    public static void main(String args[]){
        int[] input = {1,2,3};
        List<List<Integer>> permute = new Permutations().permute(input);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }

    List<List<Integer>> result; // 定义全局变量保存最终所有的排列
    boolean[] used;             // 定义状态变量保存当前状态，对应的值是否加入到路径中
    List<Integer> path;         // 定义状态变量保存当前状态，当前已经走过的路径

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        used = new boolean[nums.length];
        path = new ArrayList<>(nums.length);

        backtrack(nums, nums.length, 0);
        return result;
    }

    private void backtrack(int[] nums, int len, int depth) {
        // 状态满足最终要求，当前路径深度等于要排列的数组的深度
        if (len == depth) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 对于当前路径，遍历可走的路径
        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;

                // 递归深度搜索
                backtrack(nums, len, depth+1);

                // 回溯
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
