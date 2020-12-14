package org.alg.algorithm.john;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName SmallestK
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 * Date 12/7/20 10:36 PM
 */
public class SmallestK {

    /**
     * 基于冒泡排序的最小k个数输出
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if (k==0){
            return new int[0];
        }else if( k>= arr.length){
            return arr;
        }
        for (int i=0;i<=arr.length-1;i++){
            for (int j=arr.length-1;j>i;j--){
                int temp=0;
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        int[] res=new int[4];
        for (int i=0;i<=k-1;i++){
            res[i]=arr[i];
        }
        return res;


    }

    /**
     * 基于排序队列的最小k个数输出
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK2(int[] arr, int k) {
        if(k == 0){
            return new int[]{};
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            maxHeap.offer(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            if(maxHeap.peek() > arr[i]){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }
        return result;
    }

    /**
     * 基于快排的最小K个数输出
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestKQuickSort(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int pos = partition(arr, low, high);
            if (pos == k - 1) {
                break;
            } else if (pos < k - 1) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        int[] dest = new int[k];
        System.arraycopy(arr, 0, dest, 0, k);
        return dest;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }





    @Test
    public  void test() {
        SmallestK smk = new SmallestK();
        int[] res = smk.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        for(int i=0;i<=res.length-1;i++){
            System.out.println(res[i]+",");
        }

    }


}

