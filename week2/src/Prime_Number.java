import java.util.Scanner;

public class Prime_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            if(isPrime(num))
                System.out.println(num + " eh primo");
            else
                System.out.println(num+ " nao eh primo");

        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

