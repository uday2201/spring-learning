package com.example.spring_learning.leetcode;

public class SymmetricTreeNode {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(4);
        treeNode1.right.right = new TreeNode(3);


        System.out.println("The tree node is symmetric: " + isSymmetric(treeNode1));
    }

    private static boolean isSymmetric(TreeNode node) {
        if (node==null) return true;
        return isSymmetric(node.left, node.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left ==null || right == null || left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int data) {
        val  = data;
    }
}
