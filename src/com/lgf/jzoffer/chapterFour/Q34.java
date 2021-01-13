package com.lgf.jzoffer.chapterFour;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Q34 {

    //本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分

    //先序遍历： 按照 “根、左、右” 的顺序，遍历树的所有节点。
    //路径记录： 在先序遍历中，记录从根节点到当前节点的路径。当路径为①根节点到叶节点形成的路径
    //且②各节点值的和等于目标值 sum 时，将此路径加入结果列表。

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar){
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        //回溯
        path.removeLast();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
