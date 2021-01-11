package org.alg.algorithm.jason.structure;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(int[] arr){
        this.val = arr[0];
        if (arr.length > 1){
            ListNode listNode = new ListNode(arr[1]);
            this.next = listNode;
            for (int i = 2; i < arr.length; i++) {
                ListNode listNode1 = new ListNode(arr[i]);
                listNode.next = listNode1;
                listNode = listNode1;
            }
        }
    }

    public void print(){
        System.out.println(val);
        ListNode next = this.next;
        while (next != null){
            System.out.println(next.val);
            next = next.next;
        }
    }
}