package org.alg.algorithm.jason.divide;

/**
 * Descreption: 分治
 * 求一个数组的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * Date: 2020年12月03日
 *
 * @author WangBo
 * @version 1.0
 */
public class ReversePairs {
    public static void main(String args[]){
        int[] arr = {7,5,6,4};
        System.out.println(reversePairs(arr));

    }

    private static int res = 0;

    /**
     * 把数组分成前后两部分，先求两个数组间的逆序数，再求两个数组内部的逆序数
     */
    public static int reversePairs(int[] nums) {
        count(nums, 0, nums.length-1);
        return res;
    }

    private static void count(int[] nums, int i, int j) {
        if (i >= j) return;
        count(nums, i, i+(j-i)/2);
        count(nums, i+(j-i)/2 +1, j);
        merge(nums, i, i+(j-i)/2, j);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right-left+1];
        while (i <= mid && j <= right){
            if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            } else {
                res += mid + 1 - i;
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            nums[left+m] = temp[m];
        }
    }

}
