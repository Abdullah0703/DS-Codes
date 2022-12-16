package Seaching_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search_In_1D_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr2 = {-18, -12, 0, 2, 3, 4};
//        System.out.println("The array is: " + Arrays.toString(arr));
        System.out.println("The array is: " + Arrays.toString(arr2));
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the target element you want to find");
//        int target = sc.nextInt();
//        int ans = binarysearch(arr, target);
//        System.out.println("The element is found at index: " + ans);
        System.out.println("Enter the target element you want to find");
        int target2 = sc.nextInt();
        int ans2 = OrderAgnosticBS(arr2, target2);
        System.out.println("The element is found at index: " + ans2);
    }

    static int binarysearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
//            find the middle element
//            int mid = (start + end) / 2 might be possible that (start + end) exceeds the range of int in java
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {/*If target is smaller ignore right half*/
                end = mid - 1;
            } else if (target > arr[mid]) {/*If target is greater ignore left half*/
                start = mid + 1;
            }
        }
        return -1;
    }

    static int OrderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

//        Find whether the array is sorted in ascending or descending order
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
