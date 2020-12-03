package org.alg.algorithm.jason;

import java.util.Stack;

/**
 * Descreption: 用两个栈实现一个堆
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * Date: 2020年12月01日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q03QueueWithStack {
    public static void main(String args[]){
        CQueue obj = new CQueue();
        obj.appendTail(3);
        obj.appendTail(5);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
        obj.appendTail(7);
        param_2 = obj.deleteHead();
        System.out.println(param_2);
    }

    static class CQueue {
        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.empty()){
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            try {
                return stack2.pop();
            } catch (Exception e) {
                return -1;
            }
        }
    }
}
