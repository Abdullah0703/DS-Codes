package SortingAlgorithms;
import java.util.Arrays;
public class MergeSort_Inplace {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,9,8,7,10,12};
        System.out.println("Original Array: "+Arrays.toString(arr));
        mergesortInplace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergesortInplace(int[] arr, int si, int ei){
        if(ei -si == 1){
            return;
        }
        int mid = (si+ ei)/2;
        mergesortInplace(arr,si, mid);
        mergesortInplace(arr, mid, ei);
        mergeInplace(arr, si, mid, ei);
    }

    private static void mergeInplace(int[] arr, int si, int mid, int ei){
        int[] mix = new int[ei - si];
        int i = si;
        int j = mid;
        int k = 0;

        while (i < mid && j < ei){
            if(arr[i] < arr[j]){
                mix[k++] = arr[i++];
            }
            else {
                mix[k++] = arr[j++];
            }
        }
        //it may be possible that one of the arrays is not complete
        //copy the remaining elements
        while (i < mid){
            mix[k++] = arr[i++];
        }
        while (j < ei){
            mix[k++] = arr[j++];
        }

        for (int l = 0; l < mix.length; l++) {
            arr[si+l] = mix[l];
        }
    }
}
