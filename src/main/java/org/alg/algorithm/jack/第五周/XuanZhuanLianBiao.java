package org.alg.algorithm.jack.第五周;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XuanZhuanLianBiao {
    public ListNode rotateRight(ListNode head, int k) {
    // 思路：先将链表连成一个环，在找断点
    // 先考虑边界情况
        if(head ==null)

    {
        return null;
    }

    ListNode tmp = head;
    // 找到链表最后一个节点
    int length = 1;
    while(tmp.next !=null){
        tmp = tmp.next;
        length++;
    }

    tmp.next =head;  // 构成一个环
    ListNode c_list = head;  // 头结点
    ListNode prev = tmp; // 设置尾结点
    // 通过循环找到新的头结点，向右转n次则需要next length-k%length 次
    for(int i = 1; i<=length -k%length;i++) {
        c_list = c_list.next;
        prev = prev.next;
    }
    prev.next =null;
    return c_list;
    }
}
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
