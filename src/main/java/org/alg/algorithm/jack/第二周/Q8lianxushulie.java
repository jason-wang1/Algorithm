package org.alg.algorithm.jack.第二周;

/**
 * 面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Q8lianxushulie {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        int max =  nums[0];
        dp[0] = nums[0];
        for(int i = 1;i < len;i ++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]); //判断是跟着前面的数据继续干还是自己单干！
            max   = Math.max(max , dp[i]); //更新最后的结果
        }
        return max;
    }

}
