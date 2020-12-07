package org.alg.algorithm.jason.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * Descreption: 递归
 * 求斐波拉契数列第n项
 *
 * Date: 2020年12月02日
 *
 * @author WangBo
 * @version 1.0
 */
public class Fibonacci {
    public static void main(String args[]){
        System.out.println(getFib1(5));
    }

    /**
     * 使用递归获取斐波拉契数列第n项，这里存在大量重复计算
     */
    public static long getFib1(long n){
        System.out.println(n+"入栈");
        // n = 0,1 时，初始状态
        if (n < 2)
            return n;

        // n >= 2 时，非初始状态，假设前一状态已经解决
        long res = getFib1(n - 1) + getFib1(n - 2);
        System.out.println((n-1)+"出栈，"+(n-2)+"出栈");
        return res;
    }

    private static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    /**
     * 使用递归获取斐波拉契数列第n项，记忆化存储中间状态，避免重复计算
     */
    public static int getFib2(int n){
        // n = 0,1 时，初始状态
        if (n < 2)
            return n;

        // n >= 2 时，非初始状态，假设前一状态已经解决
        Integer res = cache.get(n);
        if (res != null){
            return res;
        } else {
            int val = getFib2(n - 1) + getFib2(n - 2);
            cache.put(n, val);
            return val;
        }
    }


    /**
     * 使用动态规划/迭代计算斐波拉契数列第n项
     */
    public static int getFib3(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
