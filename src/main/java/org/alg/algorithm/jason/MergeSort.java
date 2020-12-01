package org.alg.algorithm.jason;

import java.util.Stack;

/**
 * Descreption:
 * 链表归并排序 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * Date: 2020年12月01日
 *
 * @author WangBo
 * @version 1.0
 */
public class MergeSort {
    public static void main(String args[]){
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = new ListNode(arr1);
        ListNode list2 = new ListNode(arr2);
        ListNode res = mergeTwoLists(list1, list2);
        prtList(res);
    }

    /**
     * 在遍历两个链表时，先拿到小的值，再拿到大的值，把它们依次放入栈
     * 在构造要返回的链表时，从栈中拿到最大的元素开始构造，它指向null，被小的元素所指
     * 时间复杂度：遍历两个链表，再遍历一次栈，遍历O(2(m+n))次，m<=n，比较O(m+n)次
     * 空间复杂度：一个额外栈空间O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode res = null;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                stack.add(l1.val);
                l1 = l1.next;
            } else {
                stack.add(l2.val);
                l2 = l2.next;
            }
        }

        while (l1 != null){
            stack.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack.add(l2.val);
            l2 = l2.next;
        }

        while (!stack.empty()){
            res = new ListNode(stack.pop(), res);
        }
        return res;
    }

    public static void prtList(ListNode listNode){
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        ListNode(int[] vals) {
            ListNode listNode = null;
            for (int i = vals.length-1; i >= 0; i--) {
                listNode = new ListNode(vals[i], listNode);
            }
            this.val = listNode.val;
            this.next = listNode.next;
        }
    }
}

