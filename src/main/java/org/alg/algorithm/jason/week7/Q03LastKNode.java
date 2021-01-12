package org.alg.algorithm.jason.week7;

import org.alg.algorithm.jason.structure.ListNode;

public class Q03LastKNode {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        ListNode listNode = new Q03LastKNode().getKthFromEnd(head, 2);
        listNode.print();
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode right = head;
        ListNode left = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }

        while (right != null){
            right = right.next;
            left = left.next;
        }

        return left;
    }
}
