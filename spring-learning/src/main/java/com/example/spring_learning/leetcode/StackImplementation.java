package com.example.spring_learning.leetcode;

public class StackImplementation {
    int top;
    int size;
    int[] arrayStack;

    StackImplementation(int size) {
        this.size = size;
        this.top = -1;
        arrayStack = new int[size];
    }

    public static void main(String[] args) throws IllegalAccessException {
        StackImplementation stackImplementation = new StackImplementation(5);
        stackImplementation.push(1);
        stackImplementation.push(2);
        stackImplementation.push(3);

        System.out.println("The first popped element is: " +stackImplementation.pop());
        System.out.println("The second popped element is: " +stackImplementation.pop());
        System.out.println("The third popped element is: " +stackImplementation.pop());
        System.out.println("The last popped element is: " +stackImplementation.pop());
    }

    private boolean isFull() {
        return top == size-1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public int push(int num) {
        if(isFull()) {
            throw new IllegalArgumentException("Stack is currently full!!!");
        }
        arrayStack[++top] = num;
        return num;
    }

    public int peek() throws IllegalAccessException {
        if(isEmpty()) {
            throw new IllegalAccessException("Stack is empty!!!");
        }
        return arrayStack[top];
    }

    public int pop() throws IllegalAccessException {
        if(isEmpty()) {
            throw new IllegalAccessException("Stack is empty!!!");
        }
        return arrayStack[top--];
    }
}
