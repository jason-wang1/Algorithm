package org.alg.algorithm.jason.week1;

/**
 * Descreption: 有序数组的二分查找
 * https://leetcode-cn.com/problems/binary-search/
 * 时间复杂度：O(log(N))
 *
 * Date: 2020年11月30日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q01BinarySearch {
    public static void main(String args[]){
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
