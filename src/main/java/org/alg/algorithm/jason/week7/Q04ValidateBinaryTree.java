package org.alg.algorithm.jason.week7;

import org.alg.algorithm.jason.structure.BinaryTree;
import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

public class Q04ValidateBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {5,4,6,null,null,3,7};
        BinaryTree binaryTree = new BinaryTree(arr);
        boolean validBST = new Q04ValidateBinaryTree().isValidBST(binaryTree.root);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null) return true;

        int val = node.val;

        if (lower != null && val >= lower)
            return false;

        if (upper != null && val <= upper)
            return false;

        return helper(node.left, val, upper) && helper(node.right, lower, val);
    }
}
