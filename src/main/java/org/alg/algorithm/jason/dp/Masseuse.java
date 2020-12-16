package org.alg.algorithm.jason.dp;

/**
 * Descreption: 动态规划
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * Date: 2020年12月10日
 *
 * @author WangBo
 * @version 1.0
 */
public class Masseuse {
    public static void main(String args[]){
        int[] arr = {3,1,1,5,3,8};
        System.out.println(new Masseuse().massage(arr));
    }

    public int massage(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i-2];
            if (dp[i-1] > dp[i])
                dp[i] = dp[i-1];
        }
        return dp[nums.length-1] > dp[nums.length-2] ? dp[nums.length-1] : dp[nums.length-2];
    }
}
