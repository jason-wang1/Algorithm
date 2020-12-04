package org.alg.algorithm.jason.week1;

/**
 * Descreption: 求最大和的连续子序列的最大和
 * dp[i]:以nums[i]结尾的连续子序列的最大和
 * dp[i] = max{nums[i], nums[i]+dp[i-1]}
 *
 * Date: 2020年12月04日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q06ContinuousSequence {
    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1]<=0 ? nums[i] : dp[i-1]+nums[i];
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }
}
