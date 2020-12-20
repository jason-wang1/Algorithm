package org.alg.algorithm.jason.week4;

import org.alg.algorithm.jason.structure.Node;
/**
 * Descreption: XXXX<br/>
 * Date: 2020年12月20日
 *
 * @author WangBo
 * @version 1.0
 */
public class BinaryTreeAndLinkedList {
    public static void main(String args[]){

    }

    private Node head;
    private Node pre;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        if (node != null){
            dfs(node.left);
            if (pre != null) pre.right = node;
            else head = node;
            node.left = pre;
            pre = node;
            dfs(node.right);
        }
    }
}
