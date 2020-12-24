package org.alg.algorithm.jason.bit;

import java.util.HashSet;

/**
 * Descreption: 位运算
 * 丢失的数字
 * https://leetcode-cn.com/problems/missing-number/
 *
 * Date: 2020年12月13日
 *
 * @author WangBo
 * @version 1.0
 */
public class MissingNum {
    public static void main(String args[]){
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(new MissingNum().missingNumber2(nums));
    }

    /**
     * 使用哈希表存储数组中的元素，需要遍历两次，时间复杂度为2n；空间复杂度为n
     */
    public int missingNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 使用异或运算，时间复杂度O(n)，空间复杂度O(1)
     */
    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ i;
        }
        return res;
    }
}
