package Recursion_And_Arrays_Recursion;

public class Nto1 {
    public static void main(String[] args) {
//        Recursion_And_Arrays_Recursion.Nto1(5);
        OnetoN(5);
//        funBoth(5);
    }
    static void Nto1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        Nto1(n-1);
    }
    static void OnetoN(int n){
//  This is basically the reverse of the above function.
        if(n==0){
            return;
        }
        OnetoN(n-1);
        System.out.println(n);
    }
    static void funBoth(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }

}
