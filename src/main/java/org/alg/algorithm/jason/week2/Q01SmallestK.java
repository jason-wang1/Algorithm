package org.alg.algorithm.jason.week2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q01SmallestK {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] smallestK = new Q01SmallestK().smallestK2(arr, 4);
        for (int res : smallestK) {
            System.out.println(res);
        }
    }

    /**
     * 使用堆存储最小堆k个数，遍历一次数组
     */
    public int[] smallestK1(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (heap.peek() > arr[i]){
                heap.poll();
                heap.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    private int k;

    public int[] smallestK2(int[] arr, int k) {
        this.k = k;
        return split(arr, 0, arr.length-1);
    }

    private int[] split(int[] arr, int start, int end) {
        // 边界情况特殊处理
        if (k >= arr.length)
            return arr;

        int i = start;
        int j = end;
        int key = arr[start];
        while (i < j) {
            while (i < j && arr[j] > key)
                j--;
            while (i < j && arr[i] <= key)
                i++;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[start] = arr[i];
        arr[i] = key;
        if (i < k)
            split(arr, i, end);
        else if (i > k)
            split(arr, start, i);
        int[] res = new int[k];
        for (int n = 0; n < k; n++) {
            res[n] = arr[n];
        }
        return res;
    }

}
