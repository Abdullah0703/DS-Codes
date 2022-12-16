package Seaching_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Interpolation_Search {
    public static void main(String[] args) {
// Interpolation search is an improved variant of binary search. This search algorithm works on the
// probing position of the required value. For this algorithm to work properly, the data collection
// should be in a sorted form and equally distributed.

//   Average Case: O(log(log(n)) , Worst case: O(n) [Values increase exponentially]

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("The array is: " + Arrays.toString(arr));
        System.out.println("Enter the element you want to find:");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int index = InterpolationSearch(arr, target);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + index);
        }
    }

    static int InterpolationSearch(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (target >= arr[low] && target <= arr[high] && low <= high) {

            int probe = low + (high - low) * (target - arr[low]) / (arr[high] - arr[low]);
//            System.out.println("probe: " + probe);

            if (arr[probe] == target) {
                return probe;
            } else if (arr[probe] < target) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }
        return -1;
    }
}

