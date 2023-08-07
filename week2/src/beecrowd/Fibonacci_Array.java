package beecrowd;

import java.util.Scanner;

public class Fibonacci_Array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while(a-- > 0){
            long n = sc.nextLong();
            if(n==0)
                System.out.println("Fib(0) = 0");
            else if (n==1)
                System.out.println("Fib(1) = 1");
            else{
                long pred = 0;
                long before = 1;
                long k = 0;
                for (int i = 2; i<=n; i++){
                    k = pred + before;
                    pred = before;
                    before = k;
                }
                System.out.println("Fib(" + n+") ="+k);
            }
        }
    }
}
