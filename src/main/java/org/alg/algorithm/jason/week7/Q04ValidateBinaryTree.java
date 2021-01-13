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
        if (root == null) return true;

        return (root.left == null || (root.left.val < root.val && isValidBST(root.left)))
                && (root.right == null || (root.right.val > root.val && isValidBST(root.right)));
    }
}
