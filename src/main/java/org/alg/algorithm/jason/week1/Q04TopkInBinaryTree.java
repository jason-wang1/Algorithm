package org.alg.algorithm.jason.week1;

import org.alg.algorithm.jason.structure.BinaryTree;
import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

/**
 * Descreption: 查找一棵二叉树的第k大元素值
 * 考察点：中序遍历（递归）
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * Date: 2020年12月02日
 *
 * @author WangBo
 * @version 1.0
 */
public class Q04TopkInBinaryTree {
    public static void main(String args[]){
        int[] arrs = {8, 5, 12, 3, 10, 11, 15};
        BinaryTree binaryTree = new BinaryTree(arrs);

        System.out.println(kthLargest(binaryTree.root, 1));
    }

    static int count;
    static int res;

    /**
     * 右中左递归查找第k大元素值（从大到小遍历）
     * 时间复杂度：O(N)，会遍历完树中每一个元素，与k无关
     */
    public static int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return res;
    }

    public static void kthLargest(TreeNode root){
        if (root != null){ // 非初始状态，开始往子节点遍历
            System.out.println(root.val+" 入栈");
            kthLargest(root.right); // 先往右节点走
            if (count == 1){
                res = root.val;
                System.out.println("res = "+res);
                System.out.println(root.val+" 是第 "+count+" 大元素");
                count --;
                System.out.println(root.val+" 出栈");
                return;
            }
            System.out.println(root.val+" 是第 "+count+" 大元素");
            count --;
            kthLargest(root.left); // 再往左边走
            System.out.println(root.val+" 出栈");
        }
        // root == null 时为初始状态，直接return
    }
}
