package org.alg.algorithm.jason.week4;

/**
 * Descreption: 两个子序列的最大点积
 * https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences/
 *
 * Date: 2020年12月25日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q06MaxDot {
    public static void main(String args[]){
        int[] num1 = {-3,-8,3,-10,1,3,9};
        int[] num2 ={9,2,3,7,-9,1,-8,5,-1,-1};

        System.out.println(new Q06MaxDot().maxDotProduct(num1, num2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1][len2];

        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < len2; i++) {
            int mul = nums2[i] * nums1[0];
            if (mul > dp[0][i-1]){
                dp[0][i] = mul;
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i < len1; i++) {
            int mul = nums2[0] * nums1[i];
            if (mul > dp[i-1][0]){
                dp[i][0] = mul;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int mul = nums1[i] * nums2[j];
                int max1 = Math.max(dp[i][j - 1], dp[i - 1][j]);
                int max2 = dp[i-1][j-1] > 0 ? dp[i-1][j-1] + mul : mul;
                dp[i][j] = Math.max(max1, max2);
            }
        }

        return dp[len1 -1][len2 -1];
    }

}
