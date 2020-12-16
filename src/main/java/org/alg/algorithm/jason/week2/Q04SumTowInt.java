package org.alg.algorithm.jason.week2;

/**
 * Descreption: 两整数之和
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 *
 * Date: 2020年12月08日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q04SumTowInt {
    public static void main(String args[]){
        System.out.println(new Q04SumTowInt().getSum(1, 2));
    }

    public int getSum(int a, int b) {
        // 1.无进位相加，可以用两个二进制数[异或]
        int res1 = a ^ b;

        // 2.获得进位，可以用两个二进制数[与]，再移位
        int res2 = (a & b) << 1;

        return res1 + res2;
    }
}
