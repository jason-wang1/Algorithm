package org.alg.algorithm.jason.recursive;

import java.util.ArrayList;

/**
 * Descreption: 递归
 * 有四种面额{1, 2, 5, 10}的纸币，输出所有总和为10的排列情况
 *
 * Date: 2020年12月02日
 *
 * @author WangBo
 * @version 1.0
 */
public class Combine {
    public static void main(String args[]){
        get(10, new ArrayList<Long>());
    }

    public static long[] rewards = {1, 2, 5, 10};  // 四种面额的纸币

    public static void get(long totalReward, ArrayList<Long> result) {
        // 余额 = 0，初始状态
        if (totalReward == 0){
            System.out.println(result);
            return;
        }

        // 余额 < 0，初始状态
        if (totalReward < 0)
            return;

        // 余额 > 0，非初始状态，假设前一状态已经解决
        for (long reward : rewards) {
            ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
            newResult.add(reward);
            get(totalReward-reward, newResult);
        }
    }
}
