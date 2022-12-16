package Seaching_Algorithms;

import java.util.Arrays;

//In this we are first taking a matrices that is row and column wise sorted
public class Binary_Search_In_2D_Arrays {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50},
        };
        System.out.println(Arrays.toString(search(arr, 37)));
    }

    static int[] search(int[][] arr, int target) {
        int r = 0;
        int c = arr[0].length - 1;

        while (r < arr.length && c >= 0) {
            if (arr[r][c] == target) {
                return new int[]{r, c};
            }
            if (arr[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}
