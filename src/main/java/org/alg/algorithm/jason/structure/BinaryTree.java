package org.alg.algorithm.jason.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Descreption: XXXX<br/>
 * Date: 2020年12月03日
 *
 * @author WangBo
 * @version 1.0
 */
public class BinaryTree {
    /**
     * 树的根节点
     */
    public TreeNode root;

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归放入一个元素
     */
    public void put(int val){
//        System.out.println("插入元素："+val);
        root = put(root, val);
    }

    /**
     * put方法也是采用“递归”方法实现的，但不同于中序遍历，
     * 往左走、往右走加上了一个if else判断条件，使得它不会遍历，因此时间复杂度为O(log(N))
     */
    private TreeNode put(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
//        System.out.println(root.val+"入栈");
        if (val < root.val)
            root.left = put(root.left, val);
        else if (val > root.val)
            root.right = put(root.right, val);
//        System.out.println(root.val+"出栈");
        return root;
    }

    public BinaryTree(Integer[] vals){
        TreeNode p = new TreeNode(vals[0]);
        this.root = p;

        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        while (p != null){
            if (2*i+1 < vals.length && vals[2*i+1] != null){
                p.left = new TreeNode(vals[2*i+1]);
                queue.add(p.left);
            }
            if (2*i+2 < vals.length && vals[2*i+2] != null){
                p.right = new TreeNode(vals[2*i+2]);
                queue.add(p.right);
            }
            p = queue.poll();
            i+=1;
        }
    }
}
