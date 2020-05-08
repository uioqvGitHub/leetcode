package com.uioqv.leetcode.isSubtree;

import java.util.LinkedList;

/**
 * @author LiuGuoQing
 * @since 2020-05-07
 */
public class IsSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean isEqualse = equalTree(node, t);
            if(isEqualse) {
                return true;
            }

            if(node.left !=null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    public boolean equalTree(TreeNode t1, TreeNode t2) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(t1);
        queue2.offer(t2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode t1Node = queue1.poll();
            TreeNode t2Node = queue2.poll();

            if(t1Node.val != t2Node.val) {
                return false;
            }

            if(t1Node.left != null && t2Node.left != null) {
                queue1.offer(t1Node.left);
                queue2.offer(t2Node.left);
            } else if(!(t1Node.left == null && t2Node.left==null)) {
                return false;
            }

            if(t1Node.right != null && t2Node.right != null) {
                queue2.offer(t2Node.right);
                queue1.offer(t1Node.right);
            } else if(!(t1Node.right == null && t2Node.right==null)) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        /**
         *      3
         *     / \
         *    4   5
         *   / \
         *  1   2
         */
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode((2));

        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode((2));


        boolean subtree = new IsSubtree().isSubtree(treeNode, treeNode1);
        System.out.println(subtree);


        treeNode.left.right.left = new TreeNode(0);
        subtree = new IsSubtree().isSubtree(treeNode, treeNode1);
        System.out.println(subtree);



    }
}
