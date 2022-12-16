package Heaps;

public class MinHeapUsingArrayWithHeapSort {

    public static void minHeapify(int[] arr, int n, int i) {
        int lc = 2 * i + 1;
        int rc = 2 * i + 2;
        int small = i;

        if (lc < n && arr[small] > arr[lc]) {
            int temp = arr[small];
            arr[small] = arr[lc];
            arr[lc] = temp;
        }
        if (rc < n && arr[small] > arr[rc]) {
            int temp = arr[small];
            arr[small] = arr[rc];
            arr[rc] = temp;
        }
    }

    public static void Heap(int[] arr, int n) {
        for (int j = n / 2 - 1; j >= 0; j--) {
            minHeapify(arr, n, j);
        }
    }

    public static void HeapSort(int arr[], int n) {
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            minHeapify(arr, i, 0);
        }
    }

    public static void printHeapSort(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    void print(int arr[], int n, int element) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                System.out.print(arr[i] + " ");
                System.out.print(" left child " + arr[2 * i + 1] + " ");
                System.out.print(" right child " + arr[2 * i + 2] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int heap[] = {3, 5, 8, 17, 14, 21, 7};
        int n = heap.length;
        Heap(heap, n);
        System.out.println("After inserting 7 and heap sort the resultant heap is");
        HeapSort(heap, n);
        printHeapSort(heap, n);

    }
}
