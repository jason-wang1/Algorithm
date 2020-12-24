package org.alg.algorithm.jason.week3;

import org.alg.algorithm.jason.structure.BinaryTree;
import org.alg.algorithm.jason.structure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q04PrintBinaryTree {
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 7, 1, 6};
        BinaryTree binaryTree = new BinaryTree(arr);
        List<List<Integer>> lists = new Q04PrintBinaryTree().levelOrder(binaryTree.root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode removeNode = queue.poll();
                list.add(removeNode.val);
                if (removeNode.left != null) queue.add(removeNode.left);
                if (removeNode.right != null) queue.add(removeNode.right);

            }
            res.add(list);
        }
        return res;
    }
}
