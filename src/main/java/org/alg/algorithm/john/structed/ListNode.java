package org.alg.algorithm.john.structed;

/**
 * ClassName structed.ListNode
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 * Date 12/1/20 10:28 PM
 */
public class ListNode {
    public int val;
    public ListNode next;

    public  ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;

    }
    public  ListNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {

        ListNode head =this;
        StringBuilder sb =new StringBuilder();
        while (head.next!=null){
            sb.append(head.val+ " ");
            head=head.next;

        }
        return sb.toString();
    }
}
