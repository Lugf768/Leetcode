package com.lgf.jzoffer.chapterThree;

/**
 *输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Q26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        if (A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right)){
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode root1, TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        }else {
            return false;
        }
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
