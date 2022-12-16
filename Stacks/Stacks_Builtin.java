package Stacks;

import java.util.Stack;

public class Stacks_Builtin {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < 6; i++) {
            stack.push(i);
        }
        for (int i = 1; i < 6; i++) {
            System.out.println(stack.pop());
        }
//        If stack is empty it throws and exception
    }
}
