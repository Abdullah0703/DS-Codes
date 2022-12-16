package Recursion_And_Arrays_Recursion;

public class Check_Sorted_Array {

    public static void main(String[] args) {
       //Sorted Array
        int [] arr = {1,2,3,4};
       System.out.println(sorted(arr,0));

       //Unsorted Array
//        int [] arr1 = {3,2,1,6,5,4};
    }
    static boolean sorted(int[] arr,int index){

        if(index == arr.length -1){
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr,index+1);
    }

}
