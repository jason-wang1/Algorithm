package org.alg.algorithm.jason.structure;

/**
 * Descreption: XXXX<br/>
 * Date: 2020年12月20日
 *
 * @author WangBo
 * @version 1.0
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};