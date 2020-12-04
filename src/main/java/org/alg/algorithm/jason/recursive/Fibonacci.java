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
        System.out.println(getFib1(45));
    }

    /**
     * 使用递归获取斐波拉契数列第n项，这里存在大量重复计算
     */
    public static long getFib1(long n){
        // n = 0,1 时，初始状态
        if (n < 2)
            return n;

        // n >= 2 时，非初始状态，假设前一状态已经解决
        return getFib1(n-1) + getFib1(n-2);
    }

    private static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

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
}
