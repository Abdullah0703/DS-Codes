package Hashing;

import java.util.Scanner;

class SLLNode {
    SLLNode next;
    int data;

    public SLLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * ====================  Class HashTableChainingSinglyLinkedList ==============================
 **/
class HashTableSLL {
    public SLLNode[] table;
    public int size;

    public HashTableSLL(int tablesize) {
        table = new SLLNode[nextPrime(tablesize)];
        size = 0;
    }

    /* Function to check if hash table is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Function to clear hash table */
    public void makeEmpty() {
        int l = table.length;
        table = new SLLNode[l];
        size = 0;
    }

    /* Function to get size */
    public int getSize() {
        return size;
    }

    /* Function to insert an element */
    public void insert(int val) {
        size++;
        int pos = myhash(val);
        SLLNode nptr = new SLLNode(val);
        if (table[pos] == null)
            table[pos] = nptr;
        else {
            nptr.next = table[pos];
            table[pos] = nptr;
        }
    }

    /* Function to remove an element */
    public void remove(int val) {
        int pos = myhash(val);
        SLLNode start = table[pos];
        SLLNode end = start;
        if (start.data == val) {
            size--;
            table[pos] = start.next;
            return;
        }
        while (end.next != null && end.next.data != val) {
            end = end.next;
        }
        if (end.next == null) {
            System.out.println("\nElement not found\n");
            return;
        }
        size--;
        if (end.next.next == null) {
            end.next = null;
            return;
        }
        end.next = end.next.next;
        table[pos] = start;
    }

    /* Function myhash */
    private int myhash(Integer x) {
        int hashVal = x.hashCode();
        hashVal %= table.length;
        if (hashVal < 0)
            hashVal += table.length;
        return hashVal;
    }

    public int nextPrime(int n) {
        if (n % 2 == 0)
            n++;
        for (; !isPrime(n); n += 2) ;

        return n;
    }

    /* Function to check if given number is prime */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public void printHashTable() {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ":  ");
            SLLNode start = table[i];
            while (start != null) {
                System.out.print(start.data + "->");
                start = start.next;
            }
            System.out.println();
        }
    }
}

public class Hashing_Using_SeperateChaining {
    public static void main(String[] args) {
        System.out.println("Enter the size of the HashTable");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        HashTableSLL h = new HashTableSLL(size);
        char ch;
        /*  Perform HashTableChainingSinglyLinkedList operations  */
        do {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. clear");
            System.out.println("4. size");
            System.out.println("5. check empty");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    h.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to delete");
                    h.remove(sc.nextInt());
                    break;
                case 3:
                    h.makeEmpty();
                    System.out.println("Hash Table Cleared\n");
                    break;
                case 4:
                    System.out.println("Size = " + h.getSize());
                    break;
                case 5:
                    System.out.println("Empty status = " + h.isEmpty());
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /* Display hash table */
            h.printHashTable();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
