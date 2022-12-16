package Hashing;

import java.util.Arrays;

class Hash {
    public static int count = 0;
    int[] arr;
    int size;

    public Hash(int val) {
        arr = new int[val];
        this.size = val;
        for (int i = 0; i < size; i++) {
            arr[i] = -1;
        }
    }

    public boolean isEmpty() {
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != -1) {
                length++;
            }
        }
        if (length == size) {
            return false;
        }
        return true;
    }

    public void insert(int data) {
        if (isEmpty() == false) {
            System.out.println("No space available");
            return;
        }
        int index = data % size;
        if (arr[index] == -1) {
            arr[index] = data;
        } else if (arr[index] != -1) {
            if (count % 2 == 0) {
                System.out.println("Linear Probing started here for data: " + data);
                LinearProbing(index, data);
                count++;
            } else {
                System.out.println("Quadratic probing started here for data: " + data);
                QuadraticProbing(index, data);
                count++;
            }
        }
    }

    /**
     * ========================   LINEAR PROBING BELOW    ======================================================
     **/

    public void LinearProbing(int index, int data) {
        while (arr[index] != -1) {
            if (index == size - 1) {
                index = index - (size - 1);
                continue;
            }
            index++;
        }
        arr[index] = data;
    }

    /**
     * ========================   QUADRATIC PROBING BELOW    ======================================================
     **/

    public void QuadraticProbing(int index, int data) {
        int i = 1;
        System.out.println("Index is: " + index + " data is: " + data);
        while (arr[index] != -1) {
            System.out.println(index + "," );
            index = index + i * i;
            i++;
            if (index >= size - 1) {
                while (index > size - 1) {
                    index = index - (size);
                }
                continue;
            }
        }
        arr[index] = data;
    }

    /**
     * =================================   DOUBLE HASHING   =================================================
     **/
    public void DoubleHashing(int h1, int data) {
        int R = size - 3;
        int i = 1;
        int h2 = (R) - (data % (R));
        while (arr[(h1 + i * h2) % size] != -1) {
            i++;
            if (i == 100) {
                System.out.println("Its taking too long seems impossible");
                return;
            }
        }
        arr[(h1 + i * h2) % size] = data;
    }

}

public class HashTable {
    public static void main(String[] args) {
        Hash h = new Hash(8);
        h.insert(3);
        h.insert(2);
        h.insert(9);
        h.insert(6);
        h.insert(11);
        h.insert(13);
        h.insert(7);
        h.insert(12);
        System.out.println(Arrays.toString(h.arr));

    }
}
