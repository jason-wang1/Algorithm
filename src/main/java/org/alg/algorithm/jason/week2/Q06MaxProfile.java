package org.alg.algorithm.jason.week2;

/**
 * Descreption: 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * Date: 2020年12月10日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q06MaxProfile {
    public static void main(String args[]){
        int[] arr = {7,1,5,3,6,4};
        System.out.println(new Q06MaxProfile().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            if (prices[i] - min > res){
                res = prices[i] - min;
            }
        }
        return res;
    }
}
