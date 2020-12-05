import structed.ListNode;


/**
 * ClassName MergeSortedListNode
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 * Date 12/1/20 10:32 PM
 */
public class MergeSortedListNode {
    public  ListNode solution(ListNode l1,ListNode l2){
        ListNode preHead = new ListNode(0);
        ListNode temp = preHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1==null?l2:l1;
        return preHead.next;
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        MergeSortedListNode sol = new MergeSortedListNode();
        System.out.println(sol.solution(l1, l2));


    }
}
