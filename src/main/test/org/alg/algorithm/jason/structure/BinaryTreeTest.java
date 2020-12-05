package org.alg.algorithm.jason.structure;

import org.junit.Before;
import org.junit.Test;

/**
 * Descreption: XXXX<br/>
 * Date: 2020年12月03日
 *
 * @author WangBo
 * @version 1.0
 */
public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Before
    public void init(){
        int[] arrs = {8, 5, 12, 3, 10, 11};
        binaryTree = new BinaryTree(arrs);
    }

    @Test
    public void testPut(){
        System.out.println("========开始插入元素=====");
        binaryTree.put(15);
    }
}
