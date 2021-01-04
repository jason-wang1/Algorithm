package org.alg.algorithm.jason.week6;

import java.util.Arrays;

public class Q02SmallerNum {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] ints = new Q02SmallerNum().smallerNumbersThanCurrent(nums);
        for (int smallerNum : ints) {
            System.out.println(smallerNum);
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numSorted);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int smallNum = binarySearch(nums[i], numSorted);
            res[i] = smallNum;
        }

        return res;
    }

    private int binarySearch(int target, int[] numSorted) {
        int left = 0;
        int right = numSorted.length - 1;
        int mid = left + (right-left)/2;

        while (left <= right){
            mid = left + (right-left)/2;
            if (numSorted[mid] > target){
                right = mid-1;
            } else if (numSorted[mid] < target){
                left = mid+1;
            } else {
                if (numSorted[left] == target){
                    mid = left;
                    break;
                } else {
                    right = mid;
                }
            }
        }

        while (mid > 0 && numSorted[mid-1] == numSorted[mid])
            mid--;

        return mid;
    }
}
