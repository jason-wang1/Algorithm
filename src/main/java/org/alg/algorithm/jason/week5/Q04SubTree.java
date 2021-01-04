package org.alg.algorithm.jason.week5;

import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

public class Q04SubTree {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) &&
                (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if (a == null)
            return false;
        if (a.val == b.val)
            return recur(a.left, b.left) && recur(a.right, b.right);
        return false;
    }

}
