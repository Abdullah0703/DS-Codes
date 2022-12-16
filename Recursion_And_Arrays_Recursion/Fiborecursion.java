package Recursion_And_Arrays_Recursion;

public class Fiborecursion {
    public static void main(String[] args) {
//        int ans=fibo(4);
//        System.out.println(ans);
        int ans1=anotherfibo(5);
        System.out.println(ans1);
    }

    static int fibo(int n){
        //Base Condition
        if(n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }

    static int anotherfibo(int n){
        if(n<=1){
            return 1;
        }
        return n*anotherfibo(n-1);
    }
}
