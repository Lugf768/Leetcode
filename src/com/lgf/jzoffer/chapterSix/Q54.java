package com.lgf.jzoffer.chapterSix;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Q54 {

    int count = 0, res = 0;//形参k不能随着dfs的迭代而不断变化，为了记录迭代进程和结果，引入类变量count和res。

    public int kthLargest(TreeNode root, int k) {
        this.count = k;//利用形参值k对类变量count进行初始化
        dfs(root);//这里不要引入形参k，dfs中直接使用的是初始值为k的类变量count
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null || count == 0) return;//当root为空或者已经找到了res时，直接返回
        dfs(root.right);
        if (--count == 0) {//先--，再判断
            res = root.val;
            return;//这里的return可以避免之后的无效迭代dfs(root.left);
        }
        dfs(root.left);
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
