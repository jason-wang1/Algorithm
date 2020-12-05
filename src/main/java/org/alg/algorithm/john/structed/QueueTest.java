package org.alg.algorithm.john.structed;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName QueueTest
 * Description
 * Create by long
 * CopyRight
 * 输出二叉树深度
 * Date 12/5/20 10:30 AM
 */
public class QueueTest {
    /**
     * 广度优先遍历，也叫层度优先
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList() {
        };
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    @Test
    public  void test() {

//        [3,9,20,null,null,15,7]
        TreeNode testTree=new TreeNode(3);
        testTree.left=new TreeNode(9);
        testTree.right=new TreeNode(20);
        testTree.right.left=new TreeNode(15);
        testTree.right.right=new TreeNode(7);

        int i = maxDepth(testTree);
        System.out.println(i);


    }
}
