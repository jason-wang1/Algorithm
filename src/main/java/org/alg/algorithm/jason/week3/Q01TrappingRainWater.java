package org.alg.algorithm.jason.week3;

/**
 * Descreption: 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * Date: 2020年12月12日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q01TrappingRainWater {
    public static void main(String args[]){
        int[] rain = {4,2,0,3,2,5};
        System.out.println(new Q01TrappingRainWater().trap(rain));
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3)
            return 0;

        int[] left = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            left[i] = max;
            if (height[i] > max)
                max = height[i];
        }

        int[] right = new int[height.length];
        max = 0;
        for (int i = height.length-1; i >= 0; i--) {
            right[i] = max;
            if (height[i] > max)
                max = height[i];
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(left[i], right[i]) - height[i];
            if (temp > 0)
                res += temp;
        }
        return res;
    }

}
