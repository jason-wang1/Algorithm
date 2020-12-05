import java.util.LinkedList;

/**
 * ClassName CQueue
 * Description
 * Create by long
 * CopyRight www.baijiahulian.com
 * group bigdata-dw
 * Date 12/2/20 11:54 PM
 *
 * 使用两个链表实现
 */
public class CQueue {
    LinkedList<Integer> l1 ,l2;
    public CQueue() {
        l1=new LinkedList<Integer>();
        l2 =new LinkedList<Integer>();
    }

    public void appendTail(int value) {

        l1.addLast(value);

    }

    public int deleteHead() {

        if(l2.isEmpty()){
            return l2.removeLast();
        }else if (l1.isEmpty()){
            return -1;
        }else{
            while (!l1.isEmpty()){
                l2.addLast(l1.removeLast());
            }
            return l2.removeLast();
        }
    }
}
