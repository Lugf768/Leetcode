package com.lgf.jzoffer.chapterTwo;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Q8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;//左子节点
        TreeLinkNode right = null;//右子节点
        TreeLinkNode next = null; //指向父节点
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //判断右节点是否为空
    //① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
    //② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while(node.left != null)
                node = node.left;
            return node;
        }else {
            while(pNode.next != null) {
                TreeLinkNode parens = pNode.next;
                if(parens.left == pNode)
                    return parens;
                pNode = pNode.next;
            }
        }
        return null;
    }
}
