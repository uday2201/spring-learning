package com.example.spring_learning.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(7);

        System.out.println("The height of the above binary tree is: " + height(treeNode));

        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(3);
        treeNode1.right = new TreeNode(5);
        treeNode1.right.right = new TreeNode(6);
        treeNode1.right.right.right = new TreeNode(7);


        System.out.println("The two trees are identical: " + areSame(treeNode, treeNode1));

        System.out.println("The BST is a valid one: " + isValidBST(treeNode1));

        System.out.println("The BST is a valid one: " + isValidBST(treeNode));
    }

    // left -> root -> right
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    public static boolean isValidBST(TreeNode node) {
        return isValidBSTHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, int minValue, int maxValue) {
        if(node==null) return true;
        if(node.val <= minValue || node.val >= maxValue) return false;
        return isValidBSTHelper(node.left, minValue, node.val) && isValidBSTHelper(node.right, node.val, maxValue);
    }

    public static List<Integer> preOrderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        preOrder(node, result);
        return result;
    }

    // root -> left -> right
    public static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    // left -> right -> root
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }

    public static int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean areSame(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null || t1.val != t2.val) return false;
        return areSame(t1.left, t2.left) && areSame(t1.right, t2.right);
    }

    public static boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null || t1.val != t2.val) return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }


}
