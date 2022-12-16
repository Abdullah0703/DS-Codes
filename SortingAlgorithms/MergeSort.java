package SortingAlgorithms;

public class MergeSort {

    public static void main(String[] args){
        int array1[] = { 12, 2, 130, 5, 6, 7 };
        mergesort(array1,0, array1.length-1);
        for(int i=0 ; i< array1.length ; i++){
            System.out.print(array1[i]+"\t");
        }
    }

        public static void mergesort(int[] array, int si, int ei){
            if(si<ei){
                int mid = (si+ei)/2;
                mergesort(array,si,mid);
                mergesort(array,mid+1,ei);
                merge(array,si,mid,ei);

            }
        }

        public static void merge(int[] array, int si, int mid, int ei){
            int i = si, j = mid+1, k = 0;
            int[] arr = new int[ei-si+1];
            while(i<=mid &&j <=ei){
                if(array[i]<array[j]){
                    arr[k++]=array[i++];
                }else{
                    arr[k++]=array[j++];
                }
            }
            //remaining of 1st half part
            while(i<=mid){
                arr[k] = array[i];
                k++;
                i++;
            }
            //remaining of 2nd half part
            while(j<=ei){
                arr[k]=array[j];
                j++;
                k++;
            }
            for (int m  =si; m<arr.length ; m++){
                array[m] = arr[m];
            }
        }
}

