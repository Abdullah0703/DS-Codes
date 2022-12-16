package SortingAlgorithms;

public class Array2D_Sorting {
    public static void main(String[] args) {

        int arr[][] = {
                {58, 51, 59, 60},
                {9, 57, 53, 61},
                {58, 41, 99, 16},
                {7, 5, 591, 8},
        };
        int r = 4, c = 4;
        int oneD_arr[] = new int[r * c];
        int a = 0;
//        coverting 2d to 1d
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                oneD_arr[a] = arr[i][j];
                a++;
            }
        }
//        1d array print
        for (int i = 0; i < oneD_arr.length; i++) {
            System.out.print(oneD_arr[i] + " ");
        }
//        sorting
        sort(oneD_arr, 0, 15);
        System.out.println();
//        sorted 1d
        for (int i = 0; i < oneD_arr.length; i++) {
            System.out.print(oneD_arr[i] + " ");
        }
        a = 0;
//        converting 1d to 2d
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = oneD_arr[a];
                a++;
            }
        }
        System.out.println();
//        sorted 2d print
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }

    }
}
