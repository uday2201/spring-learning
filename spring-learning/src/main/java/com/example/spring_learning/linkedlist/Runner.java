package com.example.spring_learning.linkedlist;

public class Runner {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(15);
        linkedList.insert(25);
        linkedList.insert(35);
        linkedList.insert(45);
        linkedList.insertAtIndex(30, 2);
//        linkedList.remove(2);
//        linkedList.insertAtStart(55);
        linkedList.show();
    }
}
