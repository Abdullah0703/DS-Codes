package SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
    }

    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition_middle(arr, low, high);
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

    //Pivot as Last
    static int partition_last(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap with pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    //    Pivot as First
    static int partition_1st(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = low;
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        while (i <= high) {
            if (arr[i] <= pivot) {
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                j++;
            }
            i++;
        }
        return j - 1;
    }

    static int partition_middle(int[] arr, int low, int high) {
        int pivot = (low + high) / 2;
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        return i;
    }
}
