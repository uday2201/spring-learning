package com.example.spring_learning.leetcode;

public class MergeTwoSortedListNodes {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = null;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println("Before merging::");
        show(node);
        show(node3);

        System.out.println("After merging::");
        ListNode mergedNode = mergeListNodes(node, node3);
        show(mergedNode);
    }

    public static ListNode mergeListNodes(ListNode t1, ListNode t2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                current.next = t1;
                t1 = t1.next;
            } else {
                current.next = t2;
                t2 = t2.next;
            }
            current = current.next;
        }
        current.next = t1 != null ? t1 : t2;
        return dummy.next;
    }

    public static void show(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("null");
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}


