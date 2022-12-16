package Stacks;

import java.util.EmptyStackException;

public class Stack_In_Array {
    static class Stack {
        private int top, capacity;
        private int[] arr;

        //        Creating a Stack1
        public Stack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        //        Adding elements into the stack
        public void push(int x) {
            if (isFull()) {
                throw new StackOverflowError("Stack1 is Full");
            }
            arr[++top] = x;
        }

        //        Removing an element from the stack
        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return arr[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public void PrintStack() {
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.PrintStack();
        System.out.println("After popping");
        stack.pop();
        stack.PrintStack();
    }
}
