import java.util.Scanner;

public class Banknotes_and_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float A = scanner.nextFloat();
        scanner.close();

        int N = (int) A;
        float a = N / 100f;
        int b = N % 100;
        int c = b / 50;
        b %= 50;
        int e = b / 20;
        b %= 20;
        int g = b / 10;
        b %= 10;
        int i = b / 5;
        b %= 5;
        int k = b / 2;
        int l = b % 2;

        int E = (int) (A * 100);
        int m = E % 100;
        int n = m / 50;
        m %= 50;
        int p = m / 25;
        m %= 25;
        int r = m / 10;
        m %= 10;
        int t = m / 5;
        int u = m % 5;

        System.out.println("NOTAS:");
        System.out.printf("%d nota(s) de R$ 100.00%n", (int) a);
        System.out.printf("%d nota(s) de R$ 50.00%n", c);
        System.out.printf("%d nota(s) de R$ 20.00%n", e);
        System.out.printf("%d nota(s) de R$ 10.00%n", g);
        System.out.printf("%d nota(s) de R$ 5.00%n", i);
        System.out.printf("%d nota(s) de R$ 2.00%n", k);
        System.out.println("MOEDAS:");
        System.out.printf("%d moeda(s) de R$ 1.00%n", l);
        System.out.printf("%d moeda(s) de R$ 0.50%n", n);
        System.out.printf("%d moeda(s) de R$ 0.25%n", p);
        System.out.printf("%d moeda(s) de R$ 0.10%n", r);
        System.out.printf("%d moeda(s) de R$ 0.05%n", t);
        System.out.printf("%d moeda(s) de R$ 0.01%n", u);
    }
}

