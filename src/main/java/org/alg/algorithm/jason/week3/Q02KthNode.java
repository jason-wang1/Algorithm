package org.alg.algorithm.jason.week3;

import org.alg.algorithm.john.structed.ListNode;

public class Q02KthNode {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode root = list;
        for (int i = 2; i < 6; i++) {
            list.next = new ListNode(i);
            list = list.next;
        }

        System.out.println(new Q02KthNode().kthToLast(root, 3));
    }

    public int kthToLast(ListNode head, int k) {
        ListNode right = head;
        ListNode left = head;

        for (int i = 1; i < k; i++) {
            right = right.next;
        }

        while (right.next != null){
            right = right.next;
            left = left.next;
        }

        return left.val;
    }
}
