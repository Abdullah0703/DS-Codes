package SortingAlgorithms;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3,5,7,8,4,6,2,1};
        int n = arr.length;
        System.out.println("THE ARRAY IS "+ Arrays.toString(arr));
        radixSort(arr,n);
        System.out.println("AFTER ARRAY IS "+Arrays.toString(arr));
    }
    static void radixSort(int[] arr,int n){
        int max = Getmax(arr,n);
        for (int pos = 1; max/pos>0 ; pos*=10) {
            countsort(arr,n,pos);
        }
    }
    static void countsort(int[] arr,int n , int pos){
        int[] b = new int[n];
        int[] count = {0,0,0,0,0,0,0,0,0,0};

        for (int i = 0; i < n; i++) {
            count[(arr[i]/pos%10)]++;
        }
        for (int i = 1; i<10 ; i++) {
            count[i]+=count[i-1];
        }
        for (int i = n-1; i > 0 ; i--) {
            b[--count[(arr[i]/pos%10)]] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = b[i];
        }
    }
    static int Getmax(int[] arr,int n){
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if(arr[i]>= max){
                max = arr[i];
            }
        }
        return max;
    }
}
