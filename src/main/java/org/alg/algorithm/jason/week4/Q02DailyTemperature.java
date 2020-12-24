package org.alg.algorithm.jason.week4;

import java.util.Stack;

/**
 * Descreption: 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * Date: 2020年12月21日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q02DailyTemperature {
    public static void main(String args[]){
        int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new Q02DailyTemperature().dailyTemperatures(temperature);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    class Tuple{
        int index;
        int temperature;

        public Tuple(int index, int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
    }

    /**
     * 利用栈存储之前的温度和下标，遍历一次数组，一次栈，时间复杂度O(n)
     */
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<Tuple> stack = new Stack<>();

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && stack.peek().temperature < temps[i]){
                Tuple lastTemp = stack.pop();
                res[lastTemp.index] = i - lastTemp.index;
            }
            stack.add(new Tuple(i, temps[i]));
        }
        return res;
    }

    /**
     * 暴力解法，时间复杂度O(n^2)
     */
    public int[] dailyTemperatures1(int[] temps) {
        int[] res = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            for (int j = i+1; j < temps.length; j++) {
                if (temps[j] > temps[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}
