package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Queues_Builtin {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
//        Here Queue is an interface that's why using LL

        for (int i = 0; i < 3; i++) {
            queue.add(i);
        }
        System.out.println(queue.peek());
//        show the top/head element in the Queue
        System.out.println(queue.remove());
//        In remove the first element like the head will be removed in this case 0 will be removed
    }
}
