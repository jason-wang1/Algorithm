package org.alg.algorithm.jason.structure;

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
        root = put(root, val);
    }

    private TreeNode put(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = put(root.left, val);
        else if (val > root.val)
            root.right = put(root.right, val);
        return root;
    }

    public BinaryTree(int[] vals){
        root = null;
        for (int val : vals) {
            put(val);
        }
    }
}
