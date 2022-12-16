package Recursion_And_Arrays_Recursion;

import java.util.ArrayList;

public class Linear_Search_Recursion {
    public static void main(String[] args) {
        int[] arr ={2,3,1,4,5};
        System.out.println(linear(arr,4,0));
        System.out.println(findindex(arr,4,0));
        System.out.println(findindexlast(arr,4,arr.length-1));
//        findallindexes(arr,4,0);
//        System.out.println(list);

    }
    //returning boolean
    static boolean linear(int[] arr, int target, int index) {

        if(index == arr.length){
            return false;
        }
        return arr[index] == target || linear(arr,target,index+1);
    }

    //Finding last index
    static int findindexlast(int[] arr, int target, int index) {

        if(index == -1){
            return -1;
        }
         else if(arr[index] == target){
            return index;
        }
         else {
            return findindexlast(arr, target, -1);
        }
    }

    static int findindex(int[] arr,int target, int index){
        if (index == arr.length){
            return -1;
        }
        else if (arr[index] == target){
            return index;
        }
        else {
            return findindex(arr,target,index+1);
        }
    }

//     static ArrayList<Integer> list = new ArrayList<>();
//     static void findallindexes(int[] arr,int target,int index){
//        if(index == arr.length){
//
//        }
//        if (arr[index] == target){
//            list.add(index);
//        }
//            findallindexes(arr,target,index+1);
//    }
}
