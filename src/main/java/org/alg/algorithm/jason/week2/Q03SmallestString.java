package org.alg.algorithm.jason.week2;

/**
 * Descreption: 具有给定数值的最小字符串
 * https://leetcode-cn.com/problems/smallest-string-with-a-given-numeric-value/
 *
 * Date: 2020年12月08日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q03SmallestString {
    public static void main(String args[]){
        System.out.println(new Q03SmallestString().getSmallestString(5, 73));
    }

    /**
     * 贪心算法
     */
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for (int i = n-1; i >= 0; i--) {
            char s;
            if ((k-i) <= 26){
                s = (char) (96+k-i);
                k -= (k-i);
            } else {
                s = 'z';
                k -= 26;
            }
            res[i] = s;
        }

        return String.valueOf(res);
    }
}
