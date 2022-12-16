package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionsort(int[] arr) {
        for (int step=1;step<arr.length;step++){
            int key = arr[step];
            int j = step-1;
//          change key>arr[j] for descending order
            while (j>=0&&key<arr[j]){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
        }
    }
}
