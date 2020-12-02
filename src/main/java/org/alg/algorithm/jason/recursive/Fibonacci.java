package org.alg.algorithm.jason.recursive;

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
        System.out.println(get(7));
    }

    public static int get(int n){
        // n = 1,2 时，初始状态
        if (n == 1 || n == 2)
            return 1;

        // n > 2 时，非初始状态，假设前一状态已经解决
        return get(n-1) + get(n-2);
    }
}
