package com.example.spring_learning.linkedlist;


public class LinkedList {
    private Node head;
    public void insert(int data) {
        Node node = new Node();
        node.val = data;
        node.next = null;
        if(head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtIndex(int data, int index) {
        Node node = new Node();
        node.val = data;
        if(index == 0) {
            insertAtStart(data);
        } else {
            Node n = head;
            for (int i = 1; i < index; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.val = data;
        node.next = head;
        head = node;
    }

    public void remove(int index) {
        if(index==0) head = head.next;
        else {
            Node n = head;
            Node n1;
            for(int i=1; i<index; i++) {
                n=n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }
    }

    static Node reverseTreeNode(Node node) {
        Node prev = null;
        Node curr = node;
        while(curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}
