package org.alg.algorithm.jason.week1;

import org.alg.algorithm.jason.structure.BinaryTree;
import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

/**
 * Descreption: 计算一棵树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 *
 * Date: 2020年12月03日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q05DepthOfBinaryTree {
    public static void main(String args[]){
        int[] arrs = {8, 5, 12, 3, 10, 11, 15};
        BinaryTree binaryTree = new BinaryTree(arrs);
        System.out.println("最大深度为："+maxDepth(binaryTree.root));
    }

    static int resDepth = 0;

    public static int maxDepth(TreeNode root) {
        search(root, 0);
        return resDepth;
    }

    /**
     * 中左右遍历（递归）
     */
    public static void search(TreeNode root, int depth){
        if (root != null){
            depth ++;
            if (depth > resDepth)
                resDepth = depth;
            System.out.println(root.val+" 入栈，深度为："+depth);
            search(root.left, depth);
            search(root.right, depth);
            System.out.println(root.val+" 出栈");
        }
    }
}
