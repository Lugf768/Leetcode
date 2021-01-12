package com.lgf.jzoffer.chapterFour;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Q32_3 {

    //层序遍历 + 双端队列（奇偶层逻辑分离）
    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            deque.add(root);
        }
        while(!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if(node.left != null) {
                    deque.addLast(node.left);
                }
                if(node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(tmp);
            if(deque.isEmpty()) {
                break; // 若为空则提前跳出
            }
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if(node.right != null) {
                    deque.addFirst(node.right);
                }
                if(node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            res.add(tmp);
        }
        return res;
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
