package Recursion_And_Arrays_Recursion;

public class Reverse_a_Number {
    static int sum=0;
    static void rev1(int n){
    // 1342 reversed is 2431, so we move 2 in the first place by taking n%10 and then if we want to make
    // it at the ten thousandth place we will multiply it by 10 that would be rev=2*10=20 now when the recursion
    // calls start then 4 comes from the modulo which then gets added like rev=2*10+4=24 which kinda reverses the
    // last 2 numbers, and then we again call the func(n/10) that's how we will reverse every digit or number.
        if(n == 0){
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 +remainder;
        rev1(n/10);

    }

    public static void main(String[] args) {
        rev1(4321);
        System.out.println(sum);
    }
}
