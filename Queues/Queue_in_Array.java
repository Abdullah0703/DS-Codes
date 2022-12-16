package Queues;

import java.util.Scanner;

public class Queue_in_Array {
    private static class Queue {
        private int front, rear, capacity;
        private int[] queue;

        public Queue(int capacity) {
            front = rear = 0;
            this.capacity = capacity;
            queue = new int[capacity];
        }

        public void enqueue(int data) {
            if (capacity == rear) {
                System.out.printf("\nQueue is full\n");
                return;
            }
            // insert element at the rear
            else {
                queue[rear] = data;
                rear++;
            }
            return;
        }


        public void dequeue() {
            if (front == rear) {
                System.out.println("Queue is empty");
            } else {
                for (int i = 0; i < rear - 1; i++) {
                    queue[i] = queue[i + 1];
                }
                if (rear < capacity) {
                    queue[rear] = 0;
                }
                rear--;
            }
        }

        public void print() {
            if (front == rear) {
                System.out.printf("\nQueue is empty\n");
                return;
            } else {
//            traverse front to rear and print elements
                for (int i = 0; i < rear; i++) {
                    System.out.printf("%d <- ", queue[i]);
                }
                System.out.println();
                return;
            }
        }

        public void queuefront() {
            if (front == rear) {
                System.out.print("\nQueue is Empty\n");
                return;
            }
            System.out.printf("\nFront element is: %d", queue[front]);
            return;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();
        queue.dequeue();
        queue.print();

    }
}