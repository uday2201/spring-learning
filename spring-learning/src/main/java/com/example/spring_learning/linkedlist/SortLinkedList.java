package com.example.spring_learning.linkedlist;

import static com.example.spring_learning.linkedlist.LinkedList.reverseTreeNode;

public class SortLinkedList {

    public static void main(String[] args) {
        Node node = new Node();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node.val = 4;
        node1.val = 3;
        node2.val = 1;
        node3.val = 3;
        node4.val = 4;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        System.out.println("Original Linked List:");
        show(node);

//        Node sortedNode = sort(node);

//        System.out.println("\nSorted Linked List:");
//        show(sortedNode);

        System.out.println("\nReversed Linked List:");
        Node reversedNode = reverseTreeNode(node);
        show(reversedNode);
        System.out.println("\nGiven Linked List is a palindrome: " + isPalindrome(node));

    }

    public static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;

        // Find middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half
        Node prev = null;
        while (slow != null) {
            Node next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare both halves
        Node left = head;
        Node right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private static void show(Node sortedNode) {
        while (sortedNode != null) {
            System.out.print(sortedNode.val + " -> ");
            sortedNode = sortedNode.next;
        }
        System.out.println("null");
    }

    private static Node sort(Node head) {
        if(head==null ||  head.next==null) return head;
        Node midNode = getMiddle(head);
        Node secondHalf = midNode.next;
        midNode.next=null;
        Node left = sort(head);
        Node right = sort(secondHalf);
        return merge(left, right);
    }

    private static Node merge(Node head, Node secondHalf) {
        Node dummy = new Node(); // Dummy node to track head of merged list
        Node current = dummy;
        while(head != null && secondHalf != null) {
            if(head.val < secondHalf.val) {
                current.next = head;
                head = head.next;
            } else {
                current.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            current = current.next;
        }
        current.next = head != null ?  head : secondHalf;
        return dummy.next;
    }

    private static Node getMiddle(Node head) {
        Node slowNode = head, fastNode = head;
        while(fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}
