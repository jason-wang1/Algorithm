package org.alg.algorithm.jason.week2;

import java.util.HashMap;

/**
 * Descreption: 好数对的数目
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 *
 * Date: 2020年12月07日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q02GoodPairs {
    public static void main(String args[]){
        int[] nums = {1,1,1,1};
        int pairs = new Q02GoodPairs().numIdenticalPairs(nums);
        System.out.println(pairs);
    }

    private HashMap<Integer, Integer> dupNums;

    public int numIdenticalPairs(int[] nums) {
        dupNums = new HashMap<>(nums.length);
        for (int num : nums) {
            dupNums.put(num, dupNums.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Integer dupNum : dupNums.values()) {
            res += goodNum(dupNum);
        }
        return res;
    }

    private int goodNum(Integer dupNum) {
        if (dupNum < 2)
            return 0;
        if (dupNum == 2)
            return 1;
        return goodNum(dupNum-1) + (dupNum - 1);
    }
}
