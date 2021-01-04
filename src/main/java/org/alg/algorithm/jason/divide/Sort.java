package org.alg.algorithm.jason.divide;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 1, 8, 9, 4, 6};
        new Sort().mergeSort(arr, 0, arr.length-1);
        for (int ele : arr) {
            System.out.println(ele);
        }
    }

    public void mergeSort(int[] arr, int left, int right){
        if (left < right){
            int mid = left + (right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int p1 = left;
        int p2 = mid+1;
        int k = left;

        while (p1 <= mid && p2 <= right){
            if (arr[p1] < arr[p2]){
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }

        while (p1 <= mid){
            temp[k++] = arr[p1++];
        }
        while (p2 <= right){
            temp[k++] = arr[p2++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
