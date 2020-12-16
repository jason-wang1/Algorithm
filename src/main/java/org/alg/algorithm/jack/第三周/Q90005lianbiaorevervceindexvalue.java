package org.alg.algorithm.jack.第三周;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q90005lianbiaorevervceindexvalue {
    public int kthToLast(ListNode head,int k){
        ListNode p=head;
        for (int i = 0; i <k ; i++) {
            p=p.next;
        }
        while(p!=null){
            p=p.next;
            head=head.next;
        }
        return head.val;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
/** 解法 2：
 *     public int kthToLast(ListNode head, int k) {
 *         Stack<ListNode> stack = new Stack<>();
 *         //链表节点压栈
 *         while (head != null) {
 *             stack.push(head);
 *             head = head.next;
 *         }
 *         //在出栈串成新的链表
 *         ListNode firstNode = stack.pop();
 *         while (--k > 0) {
 *             ListNode temp = stack.pop();
 *             temp.next = firstNode;
 *             firstNode = temp;
 *         }
 *         return firstNode.val;
 *     }
 *
 *解法 3：
 *  int size;
 *
 *     public int kthToLast(ListNode head, int k) {
 *         if (head == null)
 *             return 0;
 *         int value = kthToLast(head.next, k);
 *         if (++size == k)
 *             return head.val;
 *         return value;
 *     }
 */
