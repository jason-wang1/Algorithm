package org.alg.algorithm.jason.week6;

public class Q06BestTime {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int res = new Q06BestTime().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int min = prices[0];
        int maxProfile = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > maxProfile)
                maxProfile = prices[i] - min;
            if (prices[i] < min)
                min = prices[i];
        }
        return maxProfile;
    }
}
