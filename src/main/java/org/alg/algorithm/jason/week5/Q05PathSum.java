package org.alg.algorithm.jason.week5;

import org.alg.algorithm.jason.structure.BinaryTree;
import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q05PathSum {
    public static void main(String[] args) {
        int[] ints = {10, 5, 15, 8, 12, 3, 6};
        BinaryTree binaryTree = new BinaryTree(ints);
        List<List<Integer>> lists = new Q05PathSum().pathSum(binaryTree.root, 29);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private List<List<Integer>> res;
    private LinkedList<Integer> path;
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        this.sum = sum;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int parentsSum) {
        if (node != null){
            parentsSum += node.val;
            path.addLast(node.val);
            if (parentsSum == sum && node.left == null && node.right == null){
                res.add(new ArrayList(path));
            }
            dfs(node.left, parentsSum);
            dfs(node.right, parentsSum);
            path.removeLast();
        }
    }
}
