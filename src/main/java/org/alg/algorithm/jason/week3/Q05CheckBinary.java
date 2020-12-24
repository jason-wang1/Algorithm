package org.alg.algorithm.jason.week3;

import org.alg.algorithm.jason.structure.BinaryTree;
import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

public class Q05CheckBinary {
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 7, 1};
        BinaryTree binaryTree = new BinaryTree(arr);
        System.out.println(new Q05CheckBinary().isBalanced(binaryTree.root));
    }

    /**
     * 对于任一节点，其两棵子树的高度差是否超过 1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return Math.max(depth(treeNode.left), depth(treeNode.right)) + 1;
    }

    private boolean res;
    private Integer[] depths;

    /**
     * 计算树的总任意分支高度，相差是否存在大于1
     */
    public boolean isBalanced2(TreeNode root) {
        depths = new Integer[2];
        res = true;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode treeNode, int depth) {
        if (treeNode != null){
            depth ++;
            dfs(treeNode.left, depth);
            dfs(treeNode.right, depth);
        } else {
            if (depths[0] == null || depths[0] == depth){
                depths[0] = depth;
            } else if (depths[1] == null || depths[1] == depth){
                depths[1] = depth;
            } else {
                res = false;
            }
        }
    }
}
